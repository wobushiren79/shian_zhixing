package com.shian.shianlifezx.mvp.order.presenter.impl;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderAcceptModel;
import com.shian.shianlifezx.mvp.order.model.impl.StoreOrderAcceptModelImpl;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderAcceptPresenter;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderAcceptView;

/**
 * Created by zm.
 */

public class StoreOrderAcceptPresenterImpl implements IStoreOrderAcceptPresenter {
    IStoreOrderAcceptView storeOrderAcceptView;
    IStoreOrderAcceptModel storeOrderAcceptModel;

    public StoreOrderAcceptPresenterImpl(IStoreOrderAcceptView storeOrderAcceptView) {
        this.storeOrderAcceptView = storeOrderAcceptView;
        storeOrderAcceptModel = new StoreOrderAcceptModelImpl();
    }


    @Override
    public void acceptStoreOrder(int index) {
        StoreOrderAcceptBean params = new StoreOrderAcceptBean();
        params.setOrderId(storeOrderAcceptView.getOrderId(index));
        params.setGoodsItemId(storeOrderAcceptView.getGoodsItemId(index));
        storeOrderAcceptModel.acceptOrder(storeOrderAcceptView.getContent(), params, new OnGetDataListener<StoreOrderAcceptResultBean>() {
            @Override
            public void getDataSuccess(StoreOrderAcceptResultBean result) {
                storeOrderAcceptView.acceptSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                storeOrderAcceptView.acceptFail(msg);
            }
        });
    }
}
