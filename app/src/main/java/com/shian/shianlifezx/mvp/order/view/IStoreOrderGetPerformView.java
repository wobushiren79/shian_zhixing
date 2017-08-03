package com.shian.shianlifezx.mvp.order.view;

import android.content.Context;

import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderGetPerformView {
    Context getContent();

    void getPerformInfoSuccess(StoreOrderGetPerformResultBean resultBean);

    void getPerformInfoFail(String msg);

    Long getPerformId(int index);
}
