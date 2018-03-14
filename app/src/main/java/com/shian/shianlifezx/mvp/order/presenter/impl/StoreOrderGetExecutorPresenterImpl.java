package com.shian.shianlifezx.mvp.order.presenter.impl;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetExecutorBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetExecutorResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderGetExecutorModel;
import com.shian.shianlifezx.mvp.order.model.impl.StoreOrderGetExecutorModelImpl;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderGetExecutorPresenter;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderGetExecutorView;

/**
 * Created by zm.
 */

public class StoreOrderGetExecutorPresenterImpl implements IStoreOrderGetExecutorPresenter{
    IStoreOrderGetExecutorView storeOrderGetExecutorView;
    IStoreOrderGetExecutorModel storeOrderGetExecutorModel;

    public StoreOrderGetExecutorPresenterImpl(IStoreOrderGetExecutorView storeOrderGetExecutorView) {
        this.storeOrderGetExecutorView = storeOrderGetExecutorView;
        storeOrderGetExecutorModel=new StoreOrderGetExecutorModelImpl();
    }

    @Override
    public void getListExecutor() {
        StoreOrderGetExecutorBean params=new StoreOrderGetExecutorBean();
        params.setPerformUserId(storeOrderGetExecutorView.getPerformUserId());
        storeOrderGetExecutorModel.getExecutor(storeOrderGetExecutorView.getContext(), params, new OnGetDataListener<StoreOrderGetExecutorResultBean>() {
            @Override
            public void getDataSuccess(StoreOrderGetExecutorResultBean result) {
                storeOrderGetExecutorView.getExecutorSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {

            }
        });
    }
}
