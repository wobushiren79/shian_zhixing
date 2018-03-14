package com.shian.shianlifezx.mvp.order.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetExecutorBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetExecutorResultBean;


/**
 * Created by zm.
 */

public interface IStoreOrderGetExecutorModel {
    void getExecutor(Context context, StoreOrderGetExecutorBean params, OnGetDataListener<StoreOrderGetExecutorResultBean> listener);
}
