package com.shian.shianlifezx.mvp.order.bean;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class StoreOrderAcceptBean extends BaseHttpParams{
    private Long orderId;//订单ID
    private Long goodsItemId;//执行商品ID
    private Long performId;//执行单id

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsItemId() {
        return goodsItemId;
    }

    public void setGoodsItemId(Long goodsItemId) {
        this.goodsItemId = goodsItemId;
    }

    public Long getPerformId() {
        return performId;
    }

    public void setPerformId(Long performId) {
        this.performId = performId;
    }
}
