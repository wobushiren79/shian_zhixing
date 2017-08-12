package com.shian.shianlifezx.mvp.order.model.impl;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderAcceptModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class StoreOrderAcceptModelImpl implements IStoreOrderAcceptModel {

    @Override
    public void acceptOrder(Context context, StoreOrderAcceptBean params, final OnGetDataListener<StoreOrderAcceptResultBean> listener) {
        MHttpManagerFactory.getStoreManager().acceptStoreOrder(context, params, new HttpResponseHandler<StoreOrderAcceptResultBean>() {


            @Override
            public void onStart(Request request, int id) {
                
            }

            @Override
            public void onSuccess(StoreOrderAcceptResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }

}
