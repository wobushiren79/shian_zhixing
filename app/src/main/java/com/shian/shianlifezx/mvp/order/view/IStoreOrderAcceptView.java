package com.shian.shianlifezx.mvp.order.view;

import android.content.Context;

import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderAcceptView {
    Context getContent();

    Long getOrderId(int position);

    Long getGoodsItemId(int position);

    void acceptSuccess(StoreOrderAcceptResultBean resultBean);

    void acceptFail(String msg);
}
