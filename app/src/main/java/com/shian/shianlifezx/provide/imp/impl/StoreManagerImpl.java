package com.shian.shianlifezx.provide.imp.impl;

import android.content.Context;

import com.loopj.android.http.RequestParams;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderResultBean;
import com.shian.shianlifezx.provide.base.BaseHttpParams;
import com.shian.shianlifezx.provide.base.HttpRequestExecutor;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.imp.StoreManager;

/**
 * Created by zm.
 */

public class StoreManagerImpl implements StoreManager {
    public HttpRequestExecutor excutor = new HttpRequestExecutor();
    private static StoreManagerImpl manager;
    private String BaseUrl = AppContansts.StoreURL;

    private StoreManagerImpl() {
    }


    public static StoreManagerImpl getInstance() {
        if (manager == null) {
            manager = new StoreManagerImpl();
        }
        return manager;
    }

    private <T> void requestPost(Context context,
                                 String method,
                                 Class<T> cls,
                                 BaseHttpParams params,
                                 HttpResponseHandler<T> response) {
        excutor.requestPost(context, BaseUrl + "/" + method, cls, params, response);
    }

    private <T> void requestPost(Context context,
                                 String method,
                                 Class<T> cls,
                                 BaseHttpParams params,
                                 HttpResponseHandler<T> response,
                                 boolean isDialog) {
        excutor.requestPost(context, BaseUrl + "/" + method, cls, params, response, isDialog);
    }

    @Override
    public void getStoreListData(Context context, StoreOrderBean params, HttpResponseHandler<StoreOrderResultBean> handler) {
        requestPost(context, "api/goods/perform/list", StoreOrderResultBean.class, params, handler);
    }
}
