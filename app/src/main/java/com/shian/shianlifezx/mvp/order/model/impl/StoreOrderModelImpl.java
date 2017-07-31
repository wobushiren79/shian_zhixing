package com.shian.shianlifezx.mvp.order.model.impl;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

/**
 * Created by zm.
 */

public class StoreOrderModelImpl implements IStoreOrderModel {
    @Override
    public void getStoreOrderListData(Context context, StoreOrderBean params, final OnGetDataListener<StoreOrderResultBean> listener) {
        MHttpManagerFactory.getStoreManager().getStoreListData(context, params, new HttpResponseHandler<StoreOrderResultBean>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(StoreOrderResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
