package com.shian.shianlifezx.mvp.order.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderGetPerformModel {
    void getPerformInfo(Context context, StoreOrderGetPerformBean params, OnGetDataListener<StoreOrderGetPerformResultBean> listener);
}
