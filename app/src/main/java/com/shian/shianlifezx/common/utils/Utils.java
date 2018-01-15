package com.shian.shianlifezx.common.utils;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.loopj.android.http.RequestParams;
import com.shian.shianlifezx.activity.LoginActivity;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.view.TipsDialog;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.phpparams.PHPHpAppVersionParams;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetVersion;
import com.shian.shianlifezx.service.PushService;
import com.shian.shianlifezx.service.UpDataService;
import com.shian.shianlifezx.thisenum.APPTypeEnum;
import com.shian.shianlifezx.thisenum.UpDataImportantEnum;
import com.shian.shianlifezx.view.dialog.AppUpdateDialog;

import okhttp3.Request;

public class Utils {

    /**
     * 加载图片
     *
     * @param context
     * @param imageView
     * @param imgPath
     */
    public static void loadPic(Context context, ImageView imageView, String imgPath) {
        Glide.with(context).load(imgPath).crossFade().into(imageView);
    }

    public static void loadPic(Context context, ImageView imageView, String imgPath, int placeholderId) {
        Glide.with(context).load(imgPath).crossFade().placeholder(placeholderId).into(imageView);
    }

    public static void loadPic(Context context, ImageView imageView, String imgPath, RequestListener<String, GlideDrawable> listener) {
        Glide.with(context).load(imgPath).crossFade().listener(listener).into(imageView);
    }


    public static String getDateUtils(long paramLong) {
        return TransitionDate.DateToStr(new Date(paramLong), "yyyy-MM-dd HH:mm");
    }

    public static void call(final View v, final String phone) {
        if (!TextUtils.isEmpty(phone)) {
            v.setVisibility(View.VISIBLE);
            v.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View vv) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                    if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    v.getContext().startActivity(intent);
                }
            });
        } else {
            v.setVisibility(View.GONE);
        }
    }

    public static boolean isPhoneNumber(CharSequence input) {
        if (input == null) {
            return false;
        } else {
            String regex = "(\\+\\d+)?1[3458]\\d{9}$";
            return Pattern.matches(regex, input);
        }
    }

    public static int getArrayINdex(String[] arr, String text) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(text)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 检查手机上是否安装了指定的软件
     *
     * @param context
     * @param packageName：应用包名
     * @return
     */
    public static boolean isInstalled(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        if (packageInfos != null) {
            for (int i = 0; i < packageInfos.size(); i++) {
                String pkName = packageInfos.get(i).packageName;
                if (pkName.equals(packageName)) return true;
            }
        }
        return false;
    }

    /**
     * 状态栏相关工具类
     */
    public static void setWindowStatusBarColor(Activity activity, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(activity.getResources().getColor(colorResId));

                //底部导航栏
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "没有找到版本号";
        }
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号代码
     */
    public static int getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            int versioncode = info.versionCode;
            return versioncode;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    /**
     * 检测是否有更新 并执行下载
     */
    public static void checkUpData(final Context context, final boolean isToast) {
        PHPHpAppVersionParams params = new PHPHpAppVersionParams();
        params.setAppId(APPTypeEnum.EXECUTOR.getCode());
        MHttpManagerFactory.getPHPManager().getVersion(context, params, new HttpResponseHandler<PHPHrGetVersion>() {


            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(final PHPHrGetVersion result) {
                try {
                    float versionOld = Utils.getVersionCode(context);
                    float versionNew = Float.valueOf(result.getItems().get(0).getVersionNum());
                    if (versionNew > versionOld) {
//                        TipsDialog dialog = new TipsDialog(context);
//                        dialog.setTop("新版本：" + result.getItems().get(0).getUpdataTitle());
//                        dialog.setTitle("" + result.getItems().get(0).getUpdataContent());
//                        dialog.setBottomButton("更新", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Intent intent = new Intent(context, UpDataService.class);
//                                intent.putExtra("updataUrl", AppContansts.PHP_BaseUrl + result.getItems().get(0).getAppDownLoadUrl());
//                                context.startService(intent);
//                                dialog.cancel();
//                            }
//                        });
//                        if (Integer.valueOf(result.getItems().get(0).getIsImportant()) == UpDataImportantEnum.IMPORTANT.getCode()) {
//                            dialog.setCancelable(false);
//                        } else {
//                            dialog.setTopButton("取消", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.cancel();
//                                }
//                            });
//                        }
//                        dialog.show();
                        AppUpdateDialog dialog = new AppUpdateDialog(context, AppContansts.PHP_BaseUrl + result.getItems().get(0).getAppDownLoadUrl(), APPTypeEnum.PLATFORM.getName());
                        dialog.setTitleTest(result.getItems().get(0).getUpdataTitle());
                        dialog.setContentTest("" + result.getItems().get(0).getUpdataContent());
                        if (result.getItems().get(0).getIsImportant() == 1) {
                            dialog.setMustBeUpdate(true);
                        } else {
                            dialog.setMustBeUpdate(false);
                        }
                        dialog.show();
                    } else {
                        if (isToast) {
                            ToastUtils.show(context, "当前已是最新版");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ToastUtils.show(context, "版本号获取异常");
                }
            }

            @Override
            public void onError(String message) {

            }
        }, isToast);
    }

    /**
     * 判断能否转为Activity
     *
     * @param cont
     * @return
     */
    public static BaseActivity scanForActivity(Context cont) {
        if (cont == null)
            return null;
        else if (cont instanceof BaseActivity)
            return (BaseActivity) cont;
        else if (cont instanceof ContextWrapper)
            return scanForActivity(((ContextWrapper) cont).getBaseContext());
        return null;
    }


    /**
     * 檢測是否有獲取照片權限
     *
     * @param context
     * @param resultCode
     */
    public static boolean checkPhotoPermission(Context context, int resultCode, String whyText) {
        boolean hasPermission = Utils.getPermissionToReadUserContacts(
                context,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                whyText,
                resultCode);
        return hasPermission;
    }

    /**
     * 权限检测
     */
    public static boolean getPermissionToReadUserContacts(Context context, String[] permissions, String toastContent, int requestCode) {
        /**
         * 1)使用ContextCompat.chefkSelfPermission(),因为Context.permission
         * 只在棒棒糖系统中使用
         * 2）总是检查权限（即使权限被授予）因为用户可能会在设置中移除你的权限*/
        boolean isPermission = true;
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                //权限为获取，检查用户是否被询问过并且拒绝了，如果是这样的话，给予更多
                //解释

                if (ActivityCompat.shouldShowRequestPermissionRationale(scanForActivity(context), permission)) {
                    //在界面上展示为什么需要該權限
                    Toast.makeText(context, toastContent, Toast.LENGTH_SHORT).show();
                }
                //发起请求获得用户许可,可以在此请求多个权限
                isPermission = false;
            }
        }
        if (isPermission) {
            return isPermission;
        } else {
            ActivityCompat.requestPermissions(scanForActivity(context), permissions, requestCode);
            return isPermission;
        }
    }

    /**
     * 判断是否有网络
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 跳转到登陆界面
     * @param context
     */
    public static void jumpLogin(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 开始前台服务
     * @param context
     */
    public static void startForegroundService(Context context) {
        Intent intent = new Intent(context, PushService.class);
        context.startService(intent);
    }
}

