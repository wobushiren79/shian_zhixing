package com.shian.shianlifezx.common.utils;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.loopj.android.http.RequestParams;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.view.TipsDialog;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetVersion;
import com.shian.shianlifezx.service.UpDataService;
import com.shian.shianlifezx.thisenum.APPTypeEnum;
import com.shian.shianlifezx.thisenum.UpDataImportantEnum;

public class Utils {
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
        RequestParams params = new RequestParams();
        params.put("appId", APPTypeEnum.EXECUTOR.getCode());
        MHttpManagerFactory.getPHPManager().getVersion(context, params, new HttpResponseHandler<PHPHrGetVersion>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(final PHPHrGetVersion result) {
                try {
                    float versionOld = Utils.getVersionCode(context);
                    float versionNew = Float.valueOf(result.getItems().get(0).getVersionNum());
                    if (versionNew > versionOld) {
                        TipsDialog dialog = new TipsDialog(context);
                        dialog.setTop("新版本：" + result.getItems().get(0).getUpdataTitle());
                        dialog.setTitle("" + result.getItems().get(0).getUpdataContent());
                        dialog.setBottomButton("更新", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(context, UpDataService.class);
                                intent.putExtra("updataUrl", AppContansts.PhpURL + result.getItems().get(0).getAppDownLoadUrl());
                                context.startService(intent);
                                dialog.cancel();
                            }
                        });
                        if (Integer.valueOf(result.getItems().get(0).getIsImportant()) == UpDataImportantEnum.IMPORTANT.getCode()) {
                            dialog.setCancelable(false);
                        } else {
                            dialog.setTopButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
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
}

