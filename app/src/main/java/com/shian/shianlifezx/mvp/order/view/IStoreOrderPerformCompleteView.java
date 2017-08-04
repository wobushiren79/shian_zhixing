package com.shian.shianlifezx.mvp.order.view;

import android.content.Context;

import com.shian.shianlifezx.mvp.order.bean.StoreOrderPerformCompleteResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderPerformCompleteView {
    Context getContext();

    void savePerformCompleteSuccess(StoreOrderPerformCompleteResultBean resultBean);

    void savePerformCompleteFail(String msg);

    Long getPerformId();

    String getPerformCompletePic();

    String getPerformCompleteContent();

    void getDataFail(String msg);
}
