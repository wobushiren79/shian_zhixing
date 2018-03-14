package com.shian.shianlifezx.mvp.order.bean;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

import java.util.List;

/**
 * Created by zm.
 */

public class StoreOrderGetExecutorResultBean  {
    private List<GoodsPerform> listData;

    public List<GoodsPerform> getListData() {
        return listData;
    }

    public void setListData(List<GoodsPerform> listData) {
        this.listData = listData;
    }
}
