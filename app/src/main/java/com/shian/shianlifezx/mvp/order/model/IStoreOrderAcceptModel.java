package com.shian.shianlifezx.mvp.order.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderAcceptModel {
    void acceptOrder(Context context, StoreOrderAcceptBean params, OnGetDataListener<StoreOrderAcceptResultBean> listener);
}
