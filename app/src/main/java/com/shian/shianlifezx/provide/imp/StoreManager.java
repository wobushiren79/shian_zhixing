package com.shian.shianlifezx.provide.imp;

import android.content.Context;

import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListResultBean;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

/**
 * Created by zm.
 */

public interface StoreManager {
    /**
     * 获取单项数据列表
     *
     * @param context
     * @param params
     * @param handler
     */
    void getStoreListData(Context context, StoreOrderListBean params, HttpResponseHandler<StoreOrderListResultBean> handler);


    /**
     * 接单
     * @param context
     * @param params
     * @param handler
     */
    void acceptStoreOrder(Context context, StoreOrderAcceptBean params, HttpResponseHandler<StoreOrderAcceptResultBean> handler);
}
