package com.shian.shianlifezx.mvp.order.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderSavePerformModel {
    void savePerformInfo(Context context, StoreOrderSavePerformBean params, OnGetDataListener<StoreOrderSavePerformResultBean> listener);
}
