package com.shian.shianlifezx.mvp.order.presenter.impl;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderModel;
import com.shian.shianlifezx.mvp.order.model.impl.StoreOrderModelImpl;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderPresenter;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderView;

/**
 * Created by zm.
 */

public class StoreOrderPresenterImpl implements IStoreOrderPresenter {
    IStoreOrderView storeOrderView;
    IStoreOrderModel storeOrderModel;

    public StoreOrderPresenterImpl(IStoreOrderView storeOrderView) {
        this.storeOrderView = storeOrderView;
        storeOrderModel = new StoreOrderModelImpl();
    }

    @Override
    public void getStoreOrderListData() {
        StoreOrderBean params = new StoreOrderBean();
        params.setPageSize(storeOrderView.getPageSize());
        params.setPageNumber(storeOrderView.getPageNumber());
        StoreOrderBean.Content content = new StoreOrderBean.Content();
        content.setStatus(storeOrderView.getStatus());
        params.setContent(content);
        storeOrderModel.getStoreOrderListData(storeOrderView.getContext(), params, new OnGetDataListener<StoreOrderResultBean>() {
            @Override
            public void getDataSuccess(StoreOrderResultBean result) {
                storeOrderView.getDataSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                storeOrderView.getDataFail(msg);
            }
        });
    }
}
