package com.shian.shianlifezx.mvp.order.model.impl;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderGetPerformModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class StoreOrderGetPerformModelImpl implements IStoreOrderGetPerformModel {
    @Override
    public void getPerformInfo(Context context, StoreOrderGetPerformBean params, final OnGetDataListener<StoreOrderGetPerformResultBean> listener) {
        MHttpManagerFactory.getStoreManager().getPerformInfo(context, params, new HttpResponseHandler<StoreOrderGetPerformResultBean>() {


            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(StoreOrderGetPerformResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
