package com.shian.shianlifezx.mvp.order.bean;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class StoreOrderSavePerformBean extends BaseHttpParams {
    private GoodsPerform goodsPerform;
    private GoodsExpress goodsExpress;//快递单号


    public GoodsPerform getGoodsPerform() {
        return goodsPerform;
    }

    public void setGoodsPerform(GoodsPerform goodsPerform) {
        this.goodsPerform = goodsPerform;
    }

    public GoodsExpress getGoodsExpress() {
        return goodsExpress;
    }

    public void setGoodsExpress(GoodsExpress goodsExpress) {
        this.goodsExpress = goodsExpress;
    }

}
