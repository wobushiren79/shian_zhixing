package com.shian.shianlifezx.provide.imp;

import android.content.Context;

import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderNotPassReasonBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderNotPassReasonResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderPerformCompleteBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderPerformCompleteResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformResultBean;
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
     *
     * @param context
     * @param params
     * @param handler
     */
    void acceptStoreOrder(Context context, StoreOrderAcceptBean params, HttpResponseHandler<StoreOrderAcceptResultBean> handler);


    /**
     * 提交执行信息
     *
     * @param context
     * @param params
     * @param handler
     */
    void savePerformInfo(Context context, StoreOrderSavePerformBean params, HttpResponseHandler<StoreOrderSavePerformResultBean> handler);

    /**
     * 获取执行信息
     *
     * @param context
     * @param params
     * @param handler
     */
    void getPerformInfo(Context context, StoreOrderGetPerformBean params, HttpResponseHandler<StoreOrderGetPerformResultBean> handler);

    /**
     * 提交完成信息
     *
     * @param context
     * @param params
     * @param handler
     */
    void savePerformComplete(Context context, StoreOrderPerformCompleteBean params, HttpResponseHandler<StoreOrderPerformCompleteResultBean> handler);

    /**
     * 获取审核未通过原因
     *
     * @param context
     * @param params
     * @param handler
     */
    void getNotPassReason(Context context, StoreOrderNotPassReasonBean params, HttpResponseHandler<StoreOrderNotPassReasonResultBean> handler);
}
