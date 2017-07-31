package com.shian.shianlifezx.mvp.order.presenter.impl;


import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.OrderShowResultBean;
import com.shian.shianlifezx.mvp.order.model.IOrderShowModel;
import com.shian.shianlifezx.mvp.order.model.impl.OrderShowModelImpl;
import com.shian.shianlifezx.mvp.order.presenter.IOrderShowPresenter;
import com.shian.shianlifezx.mvp.order.view.IOrderShowView;

/**
 * Created by zm.
 */

public class OrderShowPresenterImpl implements IOrderShowPresenter {
    IOrderShowModel orderShowModel;
    IOrderShowView orderShowView;

    public OrderShowPresenterImpl(IOrderShowView orderShowView) {
        this.orderShowView = orderShowView;
        orderShowModel = new OrderShowModelImpl();
    }


    @Override
    public void getOrderShowItem() {
        orderShowModel.getOrderShowItems(new OnGetDataListener<OrderShowResultBean>() {
            @Override
            public void getDataSuccess(OrderShowResultBean result) {
                orderShowView.showOrderItems(result);
            }

            @Override
            public void getDataFail(String msg) {

            }
        });
    }
}
