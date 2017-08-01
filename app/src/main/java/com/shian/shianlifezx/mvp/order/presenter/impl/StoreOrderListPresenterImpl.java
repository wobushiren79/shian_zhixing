package com.shian.shianlifezx.mvp.order.presenter.impl;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderListModel;
import com.shian.shianlifezx.mvp.order.model.impl.StoreOrderListModelImpl;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderListPresenter;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderListView;

/**
 * Created by zm.
 */

public class StoreOrderListPresenterImpl implements IStoreOrderListPresenter {
    IStoreOrderListView storeOrderListView;
    IStoreOrderListModel storeOrderModel;

    public StoreOrderListPresenterImpl(IStoreOrderListView storeOrderView) {
        this.storeOrderListView = storeOrderView;
        storeOrderModel = new StoreOrderListModelImpl();
    }

    @Override
    public void getStoreOrderListData() {
        StoreOrderListBean params = new StoreOrderListBean();
        params.setPageSize(storeOrderListView.getPageSize());
        params.setPageNumber(storeOrderListView.getPageNumber());
        StoreOrderListBean.Content content = new StoreOrderListBean.Content();
        content.setStatus(storeOrderListView.getStatus());
        params.setContent(content);
        storeOrderModel.getStoreOrderListData(storeOrderListView.getContext(), params, new OnGetDataListener<StoreOrderListResultBean>() {
            @Override
            public void getDataSuccess(StoreOrderListResultBean result) {
                storeOrderListView.getDataSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                storeOrderListView.getDataFail(msg);
            }
        });
    }
}
