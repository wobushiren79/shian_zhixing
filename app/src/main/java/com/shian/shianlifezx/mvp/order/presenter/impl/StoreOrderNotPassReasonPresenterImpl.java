package com.shian.shianlifezx.mvp.order.presenter.impl;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderNotPassReasonBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderNotPassReasonResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderNotPassReasonModel;
import com.shian.shianlifezx.mvp.order.model.impl.StoreOrderNotPassReasonModelImpl;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderNotPassReasonPresenter;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderAcceptView;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderNotPassReasonView;

/**
 * Created by zm.
 */

public class StoreOrderNotPassReasonPresenterImpl implements IStoreOrderNotPassReasonPresenter {
    IStoreOrderNotPassReasonModel storeOrderNotPassReasonModel;
    IStoreOrderNotPassReasonView storeOrderNotPassReasonView;

    public StoreOrderNotPassReasonPresenterImpl(IStoreOrderNotPassReasonView storeOrderNotPassReasonView) {
        this.storeOrderNotPassReasonView = storeOrderNotPassReasonView;
        storeOrderNotPassReasonModel = new StoreOrderNotPassReasonModelImpl();
    }

    @Override
    public void getNotPassReason(Long performId) {
        if (storeOrderNotPassReasonView.getContext() == null || performId == null || performId == -1)
            return;
        StoreOrderNotPassReasonBean params = new StoreOrderNotPassReasonBean();
        params.setPerformId(performId);
        storeOrderNotPassReasonModel.getNotPassReason(storeOrderNotPassReasonView.getContext(), params, new OnGetDataListener<StoreOrderNotPassReasonResultBean>() {
            @Override
            public void getDataSuccess(StoreOrderNotPassReasonResultBean result) {
                storeOrderNotPassReasonView.getPassReasonSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                storeOrderNotPassReasonView.getPassReasonFail(msg);
            }
        });
    }
}
