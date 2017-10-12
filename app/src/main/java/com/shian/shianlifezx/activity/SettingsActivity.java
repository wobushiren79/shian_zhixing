package com.shian.shianlifezx.activity;

import java.util.List;

import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import okhttp3.Request;

import com.baidu.android.pushservice.BasicPushNotificationBuilder;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.utils.SharePerfrenceUtils;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.common.utils.Utils;
import com.shian.shianlifezx.common.view.TipsDialog;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginOutResultBean;
import com.shian.shianlifezx.mvp.login.presenter.IUserLoginPresenter;
import com.shian.shianlifezx.mvp.login.presenter.impl.UserLoginPresenterImpl;
import com.shian.shianlifezx.mvp.login.view.IUserLoginOutView;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.params.HpConsultIdParams;
import com.suke.widget.SwitchButton;

public class SettingsActivity extends BaseActivity {
    private SharedPreferences share;
    @InjectViews({R.id.rb1, R.id.rb2})
    List<RadioButton> rbList;
    @InjectView(R.id.st_switch)
    SwitchButton switchButton;
    @InjectView(R.id.tv_switch)
    TextView tvSwitch;

    @Override
    protected void onCreate(Bundle arg0) {
        // TODO Auto-generated method stub
        super.onCreate(arg0);
        setContentView(R.layout.activity_settings);
        setTitle("设置");
        initData();
        share = getSharedPreferences("settings", -1);
        if (getIntent().getIntExtra("state", 1) == 1) {
            switchButton.setChecked(true);
            rbList.get(0).setChecked(true);
            tvSwitch.setText("当前状态为空闲");
        } else {
            switchButton.setChecked(false);
            rbList.get(1).setChecked(true);
            tvSwitch.setText("当前状态为忙碌");
        }
        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked) {
                    tvSwitch.setText("当前状态为空闲");
                    setSwitchState(isChecked);
                } else {
                    tvSwitch.setText("当前状态为忙碌");
                    setSwitchState(isChecked);
                }
            }
        });
    }

    private void initData() {
    }

    private void setSwitchState(final boolean isCheck) {
        HpConsultIdParams params = new HpConsultIdParams();
        if (isCheck) {
            params.setAppStatus(1);
        } else {
            params.setAppStatus(2);
        }

        MHttpManagerFactory.getFuneralExecutorManager().changeInfo(SettingsActivity.this, params, new HttpResponseHandler<Object>() {

            @Override
            public void onStart(Request request, int id) {
                switchButton.setEnabled(false);
            }

            @Override
            public void onSuccess(Object result) {
                switchButton.setEnabled(true);
                SharedPreferences.Editor editor = share.edit();
                editor.putBoolean("rb", isCheck);
                editor.commit();
            }

            @Override
            public void onError(String message) {
                switchButton.setEnabled(true);
            }
        });
    }

    @OnClick(R.id.tv_editorder)
    void logout(View v) {
        TipsDialog mDialog = new TipsDialog(this);
        mDialog.setTitle("是否退出当前账户");
        mDialog.setBottomButton("是", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                MHttpManagerFactory.getFuneralExecutorManager().loginout(
                        getBaseContext(), new HttpResponseHandler<Object>() {

                            @Override
                            public void onStart(Request request, int id) {

                            }

                            @Override
                            public void onSuccess(Object result) {
                                // TODO Auto-generated method stub

                            }


                            @Override
                            public void onError(String message) {
                                // TODO Auto-generated method stub

                            }
                        });
                SharePerfrenceUtils.setShareAutoLogin(getApplicationContext(), false);
                Utils.jumpLogin(SettingsActivity.this);
            }
        });
        mDialog.setTopButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        mDialog.show();
    }

    @OnClick(R.id.ll_clean)
    void clean(View v) {
        ImageLoader.getInstance().clearDiskCache();
        ToastUtils.show(this, "清除成功");
    }

    @OnCheckedChanged(R.id.rb1)
    void checkLisener(boolean isC) {
        if (!isC) return;
        HpConsultIdParams params = new HpConsultIdParams();

        params.setAppStatus(1);

        MHttpManagerFactory.getFuneralExecutorManager().changeInfo(this, params, new HttpResponseHandler<Object>() {

            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(Object result) {
                SharedPreferences.Editor editor = share.edit();
                editor.putBoolean("rb", true);
                editor.commit();
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    @OnCheckedChanged(R.id.rb2)
    void checkLisener0(boolean isC) {
        if (!isC) return;
        HpConsultIdParams params = new HpConsultIdParams();

        params.setAppStatus(2);
        MHttpManagerFactory.getFuneralExecutorManager().changeInfo(this, params, new HttpResponseHandler<Object>() {

            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(Object result) {
                SharedPreferences.Editor editor = share.edit();
                editor.putBoolean("rb", false);
                editor.commit();
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    @OnCheckedChanged({R.id.swt1, R.id.swt2})
    void checkLisener1(boolean isC) {
        BasicPushNotificationBuilder cBuilder = new BasicPushNotificationBuilder();
        cBuilder.setNotificationDefaults(Notification.DEFAULT_VIBRATE);
    }

    @OnCheckedChanged(R.id.swt2)
    void checkLisener2(boolean isC) {
        BasicPushNotificationBuilder cBuilder = new BasicPushNotificationBuilder();

//            cBuilder.setNotificationSound("android.resource://" + getPackageName() + "/" +R.raw.mm);
    }

}
