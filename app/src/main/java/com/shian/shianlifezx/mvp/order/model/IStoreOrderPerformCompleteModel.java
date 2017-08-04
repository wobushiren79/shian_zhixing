package com.shian.shianlifezx.mvp.order.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderPerformCompleteBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderPerformCompleteResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderPerformCompleteModel {
    void savePerformComplete(Context context, StoreOrderPerformCompleteBean params, OnGetDataListener<StoreOrderPerformCompleteResultBean> listener);
}
