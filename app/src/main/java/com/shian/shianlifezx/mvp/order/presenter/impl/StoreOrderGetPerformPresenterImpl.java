package com.shian.shianlifezx.mvp.order.presenter.impl;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderGetPerformModel;
import com.shian.shianlifezx.mvp.order.model.impl.StoreOrderGetPerformModelImpl;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderGetPerformPresenter;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderGetPerformView;

/**
 * Created by zm.
 */

public class StoreOrderGetPerformPresenterImpl implements IStoreOrderGetPerformPresenter {
    IStoreOrderGetPerformView storeOrderGetPerformView;
    IStoreOrderGetPerformModel storeOrderGetPerformModel;

    public StoreOrderGetPerformPresenterImpl(IStoreOrderGetPerformView storeOrderGetPerformView) {
        this.storeOrderGetPerformView = storeOrderGetPerformView;
        storeOrderGetPerformModel = new StoreOrderGetPerformModelImpl();
    }


    @Override
    public void getPerformInfo(int index) {
        StoreOrderGetPerformBean params = new StoreOrderGetPerformBean();
        params.setPerformId(storeOrderGetPerformView.getPerformId(index));
        storeOrderGetPerformModel.getPerformInfo(storeOrderGetPerformView.getContext(), params, new OnGetDataListener<StoreOrderGetPerformResultBean>() {
            @Override
            public void getDataSuccess(StoreOrderGetPerformResultBean result) {
                storeOrderGetPerformView.getPerformInfoSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                storeOrderGetPerformView.getPerformInfoFail(msg);
            }
        });
    }
}
