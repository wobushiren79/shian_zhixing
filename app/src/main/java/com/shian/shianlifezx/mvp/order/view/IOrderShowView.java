package com.shian.shianlifezx.mvp.order.view;

import android.content.Context;

import com.shian.shianlifezx.mvp.order.bean.OrderShowResultBean;


/**
 * Created by zm.
 */

public interface IOrderShowView {
    Context getContext();

    void showOrderItems(OrderShowResultBean resultBean);
}
