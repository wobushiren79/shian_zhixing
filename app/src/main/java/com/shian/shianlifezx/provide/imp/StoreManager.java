package com.shian.shianlifezx.provide.imp;

import android.content.Context;

import com.loopj.android.http.RequestParams;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderResultBean;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetVersion;

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
    void getStoreListData(Context context, StoreOrderBean params, HttpResponseHandler<StoreOrderResultBean> handler);
}
