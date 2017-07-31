package com.shian.shianlifezx.mvp.order.view;

import android.content.Context;

import com.shian.shianlifezx.mvp.order.bean.StoreOrderResultBean;

import java.util.List;

/**
 * Created by zm.
 */

public interface IStoreOrderView {
    Context getContext();

    int getPageSize();

    int getPageNumber();

    void getDataSuccess(StoreOrderResultBean resultBean);

    void getDataFail(String msg);

    List<Integer> getStatus();
}
