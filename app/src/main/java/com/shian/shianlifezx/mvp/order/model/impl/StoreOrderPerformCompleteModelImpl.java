package com.shian.shianlifezx.mvp.order.model.impl;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderPerformCompleteBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderPerformCompleteResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderPerformCompleteModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

/**
 * Created by zm.
 */

public class StoreOrderPerformCompleteModelImpl implements IStoreOrderPerformCompleteModel {
    @Override
    public void savePerformComplete(Context context, StoreOrderPerformCompleteBean params, final OnGetDataListener<StoreOrderPerformCompleteResultBean> listener) {
        MHttpManagerFactory.getStoreManager().savePerformComplete(context, params, new HttpResponseHandler<StoreOrderPerformCompleteResultBean>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(StoreOrderPerformCompleteResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
