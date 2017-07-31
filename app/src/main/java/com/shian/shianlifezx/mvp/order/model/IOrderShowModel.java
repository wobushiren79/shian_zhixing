package com.shian.shianlifezx.mvp.order.model;


import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.OrderShowResultBean;

/**
 * Created by zm.
 */

public interface IOrderShowModel {
    void getOrderShowItems(OnGetDataListener<OrderShowResultBean> listener);
}
