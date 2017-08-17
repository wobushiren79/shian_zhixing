package com.shian.shianlifezx.mvp.order.model.impl;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderNotPassReasonBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderNotPassReasonResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderNotPassReasonModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class StoreOrderNotPassReasonModelImpl implements IStoreOrderNotPassReasonModel {
    @Override
    public void getNotPassReason(Context context, StoreOrderNotPassReasonBean params, final OnGetDataListener listener) {
        MHttpManagerFactory.getStoreManager().getNotPassReason(context, params, new HttpResponseHandler<StoreOrderNotPassReasonResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(StoreOrderNotPassReasonResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
