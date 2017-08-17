package com.shian.shianlifezx.mvp.order.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderNotPassReasonBean;

/**
 * Created by zm.
 */

public interface IStoreOrderNotPassReasonModel<T> {

    void getNotPassReason(Context context, StoreOrderNotPassReasonBean params, OnGetDataListener<T> listener);
}
