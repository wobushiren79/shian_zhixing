package com.shian.shianlifezx.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.InjectView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.kf5sdk.api.CallBack;
import com.kf5sdk.init.KF5SDKConfig;
import com.kf5sdk.init.UserInfo;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.base.SaBaseApplication;
import com.shian.shianlifezx.common.LocationService;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.SharePerfrenceUtils;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.common.utils.Utils;
import com.shian.shianlifezx.fragment.FindFragment;
import com.shian.shianlifezx.fragment.HomeFragment;
import com.shian.shianlifezx.fragment.NewHomeFragment;
import com.shian.shianlifezx.fragment.NewUserCenterFragment;
import com.shian.shianlifezx.fragment.OrderFragment;
import com.shian.shianlifezx.fragment.UserCenterFragment;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.params.HpConsultIdParams;
import com.shian.shianlifezx.provide.result.HrCommentResult;
import com.shian.shianlifezx.service.PushService;

import org.support.v4.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity  {
    @InjectView(R.id.fl_main)
    View flMain;
    @InjectView(R.id.rb_main_1)
    RadioButton rbMain1;
    @InjectView(R.id.rb_main_2)
    RadioButton rbMain2;
    @InjectView(R.id.rb_main_3)
    RadioButton rbMain3;
    @InjectView(R.id.rb_main_4)
    RadioButton rbMain4;
    private FragmentManager mFragmentManager;
    private FragmentTransaction transcation;
//    private HomeFragment homeFragment;
    private NewHomeFragment homeFragment;
    private FindFragment findFragment;
    private OrderFragment orderFragment;
//    private UserCenterFragment userFragment;
    private NewUserCenterFragment userFragment;

    List<RadioButton> listRB = new ArrayList<>();
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_main);
        initDate();
        initView();
        initIM();
        initPermission();
        startPushService();

        //检测更新
        Utils.checkUpData(this, false);
    }
    private void startPushService() {
        Intent intent=new Intent(MainActivity.this, PushService.class);
        startService(intent);
    }
    @TargetApi(23)
    private void initPermission() {
        int hasWriteContactsPermission = PermissionChecker.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            Activity activty = this;
            ActivityCompat.requestPermissions(activty, new String[]{Manifest.permission.CALL_PHONE,},
                    1002);
            return;
        }

//        if (Build.VERSION.SDK_INT >= 23) {
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1002);
//            } else {
//
//            }
//        } else {
//
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1002) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//            } else {
//
//            }
            if (permissions[0].equals(Manifest.permission.CALL_PHONE) && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //用户同意使用write
                Log.v("this","1");
            } else {
                //用户不同意，自行处理即可
                finish();
                Log.v("this","2");
            }
        }
    }

    private void initIM() {
        String name = SharePerfrenceUtils.getLoginShare(this).getUsername();
        UserInfo userInfo = new UserInfo();
        userInfo.name = name;
        byte[] ips = name.getBytes();
        StringBuffer sb = new StringBuffer();
        sb.append("18030");
        for (byte b : ips) {
            int i = b;
            sb.append("" + i);
        }
        userInfo.sdkName = "来自世安工单";
        if (sb.toString().length() > 11)
            userInfo.phone = sb.toString().substring(0, 11);
        else
            userInfo.phone = sb.toString().substring(0, sb.toString().length() - 1);
        userInfo.helpAddress = "wenshikai.kf5.com";
        userInfo.email = name + "@sina.com";
        userInfo.deviceToken = name;
        userInfo.appId = "001577de0e0afa0ab1ff154110f0fc731dcee382d3b6b8b8";
        KF5SDKConfig.INSTANCE.init(this, userInfo, new CallBack() {
            @Override
            public void onSuccess(String result) {
            }

            @Override
            public void onFailure(String result) {
            }
        });
    }


    private void initDate() {
        mFragmentManager = getSupportFragmentManager();
    }

    private void initView() {
        setTitle("title");
        rbMain1.setOnCheckedChangeListener(new RBCheckListener());
        rbMain2.setOnCheckedChangeListener(new RBCheckListener());
        rbMain3.setOnCheckedChangeListener(new RBCheckListener());
        rbMain4.setOnCheckedChangeListener(new RBCheckListener());
        showFragment(R.id.rb_main_1);
        MHttpManagerFactory.getAccountManager().getMessageCount(this,
                new HttpResponseHandler<HrCommentResult>() {

                    @Override
                    public void onSuccess(HrCommentResult result) {
                        // TODO Auto-generated method stub
                        AppContansts.MessageCount = result.getCount();
                        if (result.getCount() == 0) {
                            setMessageIconVisible(View.GONE);
                        } else {
                            setMessageIconVisible(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onStart() {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onError(String message) {
                        // TODO Auto-generated method stub

                    }
                });
        initRB();
    }

    /**
     * 设置rb的大小
     */
    private void initRB() {
        listRB.add(rbMain1);
        listRB.add(rbMain2);
        listRB.add(rbMain3);
        listRB.add(rbMain4);
        for (RadioButton rb : listRB) {
            Rect rect = new Rect();
            rect.set(0, 0, getResources().getDimensionPixelOffset(R.dimen.dimen_48dp), getResources().getDimensionPixelOffset(R.dimen.dimen_48dp)); // 这里分别是 left top right bottom  代表距离父view 的距离   长宽 是  right-left   bottom-top
            //注意 xml没有设置 drawableTop 的图片话  drawableT 为null 的情况
            Drawable drawableT = rb.getCompoundDrawables()[1]; // getCompoundDrawables()得到一个数组  0 1 2 3 对应 left top right bottom 方向的drawable
            drawableT.setBounds(rect);// 大小和位置控制
            rb.setCompoundDrawables(null, drawableT, null, null); // 设置drawable    对应 left top right bottom 方向的drawable
        }
    }

    private void showFragment(int state) {
        transcation = mFragmentManager.beginTransaction();
        switch (state) {
            case R.id.rb_main_1:
                if (homeFragment == null) {
                    homeFragment = new NewHomeFragment();
                }
                transcation.replace(R.id.fl_main, homeFragment);
                break;
            case R.id.rb_main_2:
                if (orderFragment == null) {
                    orderFragment = new OrderFragment();
                }
                transcation.replace(R.id.fl_main, orderFragment);
                break;
            case R.id.rb_main_3:
                if (findFragment == null) {
                    findFragment = new FindFragment();
                }
                transcation.replace(R.id.fl_main, findFragment);
                break;
            case R.id.rb_main_4:
                if (userFragment == null) {
                    userFragment = new NewUserCenterFragment();
                }
                transcation.replace(R.id.fl_main, userFragment);
                break;

            default:
                break;
        }
        transcation.commit();
    }

    class RBCheckListener implements OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            if (isChecked) {
                showFragment(buttonView.getId());
            }
        }

    }

    private long currentTime;
    private int count;

    @Override
    public void onBackPressed() {
        if (count == 0) {
            currentTime = System.currentTimeMillis();
            count = 1;
            ToastUtils.show(this, "再按一次返回桌面");
        } else if (count == 1) {
            if (Math.abs(System.currentTimeMillis() - currentTime) < 2000) {
                exitApp();
                count = 0;
            } else {
                currentTime = System.currentTimeMillis();
                count = 1;
                ToastUtils.show(this, "再按一次返回桌面");
            }
        }
    }

    private void exitApp() {
        finish();
        MHttpManagerFactory.getAccountManager().loginout(this,
                new HttpResponseHandler<Object>() {

                    @Override
                    public void onSuccess(Object result) {

                    }

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onError(String message) {
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1010) {
            Intent in = new Intent(this, LoginActivity.class);
            startActivity(in);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        locationService.unregisterListener(mListener); // 注销掉监听
        locationService.stop(); // 停止定位服务
        super.onDestroy();
    }

    private LocationService locationService;

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        // -----------location config ------------
        locationService = ((SaBaseApplication) getApplication()).locationService;
        // 获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mListener);
        // 注册监听
        int type = getIntent().getIntExtra("from", 0);
//		if (type == 0) {
        locationService.setLocationOption(locationService
                .getDefaultLocationClientOption());
//		} else if (type == 1) {
//			locationService.setLocationOption(locationService.getOption());
//		}
        locationService.start();// 定位SDK
        // start之后会默认发起一次定位请求，开发者无须判断isstart并主动调用request
    }


    private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // TODO Auto-generated method stub
            if (null != location
                    && location.getLocType() != BDLocation.TypeServerError) {
                StringBuffer sb = new StringBuffer(256);
                sb.append("time : ");
                /**
                 * 时间也可以使用systemClock.elapsedRealtime()方法 获取的是自从开机以来，每次回调的时间；
                 * location.getTime() 是指服务端出本次结果的时间，如果位置不发生变化，则时间不变
                 */
                sb.append(location.getTime());
                sb.append("\nlocType : ");// 定位类型
                sb.append(location.getLocType());
//                sb.append("\nlocType description : ");// *****对应的定位类型说明*****
//                sb.append(location.getLocTypeDescription());
                sb.append("\nlatitude : ");// 纬度
                sb.append(location.getLatitude());
                sb.append("\nlontitude : ");// 经度
                sb.append(location.getLongitude());
                Log.e("tag", "" + sb.toString());
                if (location.getAddrStr() == null) return;
                Log.e("tag", "" + location.getAddrStr());

                location(location.getAddrStr());
                AppContansts.LocalString = location.getAddrStr();
                AppContansts.LOCAL_PROVINCE = location.getAddress().province;
                AppContansts.LOCAL_CITY = location.getAddress().city;
                AppContansts.LOCAL_COUNTY = location.getAddress().district;
                AppContansts.LOCAL_STREET = location.getAddress().street;
                AppContansts.LOCAL_STREETNUM = location.getAddress().streetNumber;
                AppContansts.LOCAL_ADDRESS = location.getAddress().address;
                AppContansts.LOCAL_latitude = location.getLatitude();
                AppContansts.LOCAL_longitude = location.getLongitude();
                setTitleLocation(AppContansts.LOCAL_STREET + AppContansts.LOCAL_STREETNUM);
            }
        }

    };

    private void location(final String curAddress) {
        if (!curAddress.equals(AppContansts.LocalString)) {
            HpConsultIdParams params = new HpConsultIdParams();
            params.setCurAddress(curAddress);
            MHttpManagerFactory.getAccountManager().changeCurAddress(this, params, new HttpResponseHandler<Object>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onError(String message) {

                }

                @Override
                public void onSuccess(Object result) {
                    Log.i("tag", "changeInfo" + curAddress);
                }
            });
        }
    }
}
