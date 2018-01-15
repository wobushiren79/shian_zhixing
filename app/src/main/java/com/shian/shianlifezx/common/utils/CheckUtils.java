package com.shian.shianlifezx.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import static com.shian.shianlifezx.common.utils.Utils.scanForActivity;

/**
 * Created by zm.
 */

public class CheckUtils {
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
//                if (ActivityCompat.shouldShowRequestPermissionRationale(scanForActivity(context), permission)) {
//                    //在界面上展示为什么需要該權限
//                    Toast.makeText(context, toastContent, Toast.LENGTH_SHORT).show();
//                }
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


}
