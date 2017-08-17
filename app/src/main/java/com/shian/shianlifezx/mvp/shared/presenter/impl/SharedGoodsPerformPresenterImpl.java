package com.shian.shianlifezx.mvp.shared.presenter.impl;

import com.shian.shianlifezx.mvp.shared.model.ISharedGoodsPerformModel;
import com.shian.shianlifezx.mvp.shared.model.impl.SharedGoodsPerformModelImpl;
import com.shian.shianlifezx.mvp.shared.presenter.ISharedGoodsPerformPresenter;
import com.shian.shianlifezx.mvp.shared.view.ISharedGoodsPerformExecuteView;

/**
 * Created by zm.
 */

public class SharedGoodsPerformPresenterImpl implements ISharedGoodsPerformPresenter {
    ISharedGoodsPerformModel sharedGoodsPerformModel;
    ISharedGoodsPerformExecuteView sharedGoodsPerformExecuteView;

    public SharedGoodsPerformPresenterImpl(ISharedGoodsPerformExecuteView sharedGoodsPerformView) {
        this.sharedGoodsPerformExecuteView = sharedGoodsPerformView;
        sharedGoodsPerformModel = new SharedGoodsPerformModelImpl();
    }


    @Override
    public void getExecuteData() {
        if (sharedGoodsPerformExecuteView == null || sharedGoodsPerformExecuteView.getContext() == null) {
            return;
        }

        String executorName = sharedGoodsPerformModel.getExecutorName(sharedGoodsPerformExecuteView.getContext());
        String executorPhone = sharedGoodsPerformModel.getExecutorPhone(sharedGoodsPerformExecuteView.getContext());

        sharedGoodsPerformExecuteView.setExecutorName(executorName);
        sharedGoodsPerformExecuteView.setExecutorPhone(executorPhone);
    }

    @Override
    public void setExecuteData() {
        if (sharedGoodsPerformExecuteView == null || sharedGoodsPerformExecuteView.getContext() == null) {
            return;
        }
        sharedGoodsPerformModel.setExecutorName(sharedGoodsPerformExecuteView.getContext(), sharedGoodsPerformExecuteView.getExecutorName());
        sharedGoodsPerformModel.setExecutorPhone(sharedGoodsPerformExecuteView.getContext(), sharedGoodsPerformExecuteView.getExecutorPhone());
    }
}
