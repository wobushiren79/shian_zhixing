package com.shian.shianlifezx.mvp.order.view;

import android.content.Context;

import com.shian.shianlifezx.mvp.order.bean.StoreOrderListResultBean;

import java.util.List;

/**
 * Created by zm.
 */

public interface IStoreOrderListView {
    Context getContext();

    int getPageSize();

    int getPageNumber();

    void getDataSuccess(StoreOrderListResultBean resultBean);

    void getDataFail(String msg);

    List<Integer> getStatus();
}
