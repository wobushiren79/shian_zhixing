package com.shian.shianlifezx.provide.imp.impl;

import android.content.Context;

import com.shian.shianlifezx.provide.base.BaseHttpParams;
import com.shian.shianlifezx.provide.base.HttpRequestExecutor;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.imp.PHPManager;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetLoginAdvertisement;

/**
 * Created by Administrator on 2017/3/4.
 */

public class PHPManagerImpl implements PHPManager {
    public HttpRequestExecutor excutor = new HttpRequestExecutor();
    private static PHPManager manager;
    private PHPManagerImpl() {
    }
    public static PHPManager getInstance() {
        if (manager == null) {
            manager = new PHPManagerImpl();
        }
        return manager;
    }


    @Override
    public void loginAdvertisement(Context context, HttpResponseHandler<PHPHrGetLoginAdvertisement> handler) {
        excutor.requestPHPPost(context, "Home/index/loginbanner", PHPHrGetLoginAdvertisement.class,
                new BaseHttpParams(), handler);
    }
    @Override
    public void mainAdvertisement(Context context, HttpResponseHandler<PHPHrGetLoginAdvertisement> handler) {
        excutor.requestPHPPost(context, "Home/index/indexbanner", PHPHrGetLoginAdvertisement.class,
                new BaseHttpParams(), handler);
    }
}
