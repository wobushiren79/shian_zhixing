package com.shian.shianlifezx.mvp.order.model.impl;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderListModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class StoreOrderListModelImpl implements IStoreOrderListModel {
    @Override
    public void getStoreOrderListData(Context context, StoreOrderListBean params, final OnGetDataListener<StoreOrderListResultBean> listener) {
        MHttpManagerFactory.getStoreManager().getStoreListData(context, params, new HttpResponseHandler<StoreOrderListResultBean>() {


            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(StoreOrderListResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
