package com.shian.shianlifezx.provide.imp.impl;

import android.content.Context;

import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformResultBean;
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
    public void getStoreListData(Context context, StoreOrderListBean params, HttpResponseHandler<StoreOrderListResultBean> handler) {
        requestPost(context, "api/goods/perform/list", StoreOrderListResultBean.class, params, handler);
    }

    @Override
    public void acceptStoreOrder(Context context, StoreOrderAcceptBean params, HttpResponseHandler<StoreOrderAcceptResultBean> handler) {
        requestPost(context, "api/goods/perform/accept", StoreOrderAcceptResultBean.class, params, handler,true);
    }

    @Override
    public void savePerformInfo(Context context, StoreOrderSavePerformBean params, HttpResponseHandler<StoreOrderSavePerformResultBean> handler) {
        requestPost(context, "api/goods/perform/updatePerformInfo", StoreOrderSavePerformResultBean.class, params, handler,true);
    }
}
