package com.shian.shianlifezx.provide.imp.impl;

import android.content.Context;

import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.provide.base.BaseHttpParams;
import com.shian.shianlifezx.provide.base.BaseManagerImpl;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.imp.PHPManager;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetAdvertisement;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetDynamic;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetHotIssue;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetSiftListData;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetVersion;

/**
 * Created by Administrator on 2017/3/4.
 */

public class PHPManagerImpl extends BaseManagerImpl implements PHPManager {

    private static PHPManager manager;

    private PHPManagerImpl() {
        super();
        baseUrl = AppContansts.PHP_BaseUrl;
    }

    public static PHPManager getInstance() {
        if (manager == null) {
            manager = new PHPManagerImpl();
        }
        return manager;
    }

    @Override
    public void getAdvertisement(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetAdvertisement> handler) {
        requestGet(context, "Home/index/advertising", PHPHrGetAdvertisement.class,
                params, handler, false);
    }

    @Override
    public void getDynamicInfo(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetDynamic> handler) {
        requestGet(context, "Home/index/dynamic", PHPHrGetDynamic.class,
                params, handler, false);
    }

    @Override
    public void getSiftListData(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetSiftListData> handler) {
        requestGet(context, "Home/index/sift", PHPHrGetSiftListData.class,
                params, handler, false);
    }

    @Override
    public void setSiftData(Context context, BaseHttpParams params, HttpResponseHandler<Object> handler) {
        requestGet(context, "Home/index/siftuser", Object.class,
                params, handler, false);
    }

    @Override
    public void getHotIssue(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetHotIssue> handler) {
        requestGet(context, "Home/index/help", PHPHrGetHotIssue.class,
                params, handler, false);
    }

    @Override
    public void setOpinion(Context context, BaseHttpParams params, HttpResponseHandler<Object> handler, boolean isDialog) {
        requestGet(context, "Home/index/opinion", Object.class,
                params, handler, isDialog);
    }

    @Override
    public void getVersion(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetVersion> handler, boolean isDialog) {
        requestGet(context, "Home/index/edition", PHPHrGetVersion.class,
                params, handler, isDialog);
    }

}
