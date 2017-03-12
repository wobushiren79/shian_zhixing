package com.shian.shianlifezx.common.utils;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
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

public class Utils
{
  public static String getDateUtils(long paramLong)
  {
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
					((Activity)v.getContext()).startActivity(intent);
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

	public static int getArrayINdex(String[] arr,String text){
		int index=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(text)){
				index=i;
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
			int versioncode=info.versionCode;
			return versioncode;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}

