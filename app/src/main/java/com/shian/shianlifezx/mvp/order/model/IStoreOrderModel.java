package com.shian.shianlifezx.mvp.order.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderModel {

    /**
     * 获取单项数据列表
     *
     * @param context
     * @param params
     * @param listener
     */
    void getStoreOrderListData(Context context, StoreOrderBean params, OnGetDataListener<StoreOrderResultBean> listener);
}
