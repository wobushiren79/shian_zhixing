package com.shian.shianlifezx.mvp.order.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderListModel {

    /**
     * 获取单项数据列表
     *
     * @param context
     * @param params
     * @param listener
     */
    void getStoreOrderListData(Context context, StoreOrderListBean params, OnGetDataListener<StoreOrderListResultBean> listener);
}
