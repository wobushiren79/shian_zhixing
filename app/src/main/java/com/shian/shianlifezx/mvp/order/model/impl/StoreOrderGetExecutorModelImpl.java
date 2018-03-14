package com.shian.shianlifezx.mvp.order.model.impl;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.GoodsPerform;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetExecutorBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetExecutorResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderNotPassReasonResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderGetExecutorModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

import java.util.List;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class StoreOrderGetExecutorModelImpl implements IStoreOrderGetExecutorModel {
    @Override
    public void getExecutor(Context context, StoreOrderGetExecutorBean params, final OnGetDataListener<StoreOrderGetExecutorResultBean> listener) {
        MHttpManagerFactory.getStoreManager().getListExecutor(context, params, new HttpResponseHandler<StoreOrderGetExecutorResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(StoreOrderGetExecutorResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
