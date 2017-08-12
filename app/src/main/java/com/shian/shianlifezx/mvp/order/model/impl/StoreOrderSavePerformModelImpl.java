package com.shian.shianlifezx.mvp.order.model.impl;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderSavePerformModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class StoreOrderSavePerformModelImpl implements IStoreOrderSavePerformModel {
    @Override
    public void savePerformInfo(Context context, StoreOrderSavePerformBean params, final OnGetDataListener<StoreOrderSavePerformResultBean> listener) {
        MHttpManagerFactory.getStoreManager().savePerformInfo(context, params, new HttpResponseHandler<StoreOrderSavePerformResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(StoreOrderSavePerformResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
