package com.shian.shianlifezx.provide.imp;

import android.content.Context;

import com.loopj.android.http.RequestParams;
import com.shian.shianlifezx.provide.base.HttpManager;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetDynamic;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetLoginAdvertisement;


/**
 * Created by Administrator on 2017/3/4.
 */

public interface PHPManager extends HttpManager {
    /**
     * 获取登录页广告
     *
     * @param context
     * @param handler
     */
    public void loginAdvertisement(Context context, HttpResponseHandler<PHPHrGetLoginAdvertisement> handler);

    /**
     * 获取首页广告
     *
     * @param context
     * @param handler
     */
    public void mainAdvertisement(Context context, HttpResponseHandler<PHPHrGetLoginAdvertisement> handler);
    /**
     * 获取app广告
     * @param context
     * @param handler
     */
    public void appAdvertisement(Context context,HttpResponseHandler<PHPHrGetLoginAdvertisement> handler);

    /**
     * 获取重要通知
     * @param context
     * @param params
     * @param handler
     */
    public void getDynamicInfo(Context context, RequestParams params, HttpResponseHandler<PHPHrGetDynamic> handler);
}
