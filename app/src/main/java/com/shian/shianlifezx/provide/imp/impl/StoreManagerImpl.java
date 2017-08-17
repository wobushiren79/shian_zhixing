package com.shian.shianlifezx.provide.imp.impl;

import android.content.Context;

import com.shian.shianlifezx.common.contanst.AppContansts;
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
import com.shian.shianlifezx.provide.base.BaseHttpParams;
import com.shian.shianlifezx.provide.base.BaseManagerImpl;
import com.shian.shianlifezx.provide.base.HttpRequestExecutor;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.imp.StoreManager;

/**
 * Created by zm.
 */

public class StoreManagerImpl extends BaseManagerImpl implements StoreManager {
    private static StoreManagerImpl manager;

    private StoreManagerImpl() {
        super();
        baseUrl = AppContansts.Store_BaseUrl;
    }


    public static StoreManagerImpl getInstance() {
        if (manager == null) {
            manager = new StoreManagerImpl();
        }
        return manager;
    }


    @Override
    public void getStoreListData(Context context, StoreOrderListBean params, HttpResponseHandler<StoreOrderListResultBean> handler) {
        requestPost(context, "api/goods/perform/list", StoreOrderListResultBean.class, params, handler);
    }

    @Override
    public void acceptStoreOrder(Context context, StoreOrderAcceptBean params, HttpResponseHandler<StoreOrderAcceptResultBean> handler) {
        requestPost(context, "api/goods/perform/accept", StoreOrderAcceptResultBean.class, params, handler, true);
    }

    @Override
    public void savePerformInfo(Context context, StoreOrderSavePerformBean params, HttpResponseHandler<StoreOrderSavePerformResultBean> handler) {
        requestPost(context, "api/goods/perform/updatePerformInfo", StoreOrderSavePerformResultBean.class, params, handler, true);
    }

    @Override
    public void getPerformInfo(Context context, StoreOrderGetPerformBean params, HttpResponseHandler<StoreOrderGetPerformResultBean> handler) {
        requestPost(context, "api/goods/perform/findPerformInfoByPerformId", StoreOrderGetPerformResultBean.class, params, handler, true);
    }

    @Override
    public void savePerformComplete(Context context, StoreOrderPerformCompleteBean params, HttpResponseHandler<StoreOrderPerformCompleteResultBean> handler) {
        requestPost(context, "api/goods/perform/savePerformFinishInfo", StoreOrderPerformCompleteResultBean.class, params, handler, true);
    }

    @Override
    public void getNotPassReason(Context context, StoreOrderNotPassReasonBean params, HttpResponseHandler<StoreOrderNotPassReasonResultBean> handler) {
        requestPost(context, "api/goods/perform/getNotPassAuditReason", StoreOrderNotPassReasonResultBean.class, params, handler, true);
    }
}
