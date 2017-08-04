package com.shian.shianlifezx.mvp.order.presenter.impl;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderPerformCompleteBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderPerformCompleteResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderPerformCompleteModel;
import com.shian.shianlifezx.mvp.order.model.impl.StoreOrderPerformCompleteModelImpl;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderPerformCompletePresenter;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderPerformCompleteView;

/**
 * Created by zm.
 */

public class StoreOrderPerformCompletePresenterImpl implements IStoreOrderPerformCompletePresenter {
    IStoreOrderPerformCompleteView storeOrderPerformCompleteView;
    IStoreOrderPerformCompleteModel storeOrderPerformCompleteModel;

    public StoreOrderPerformCompletePresenterImpl(IStoreOrderPerformCompleteView storeOrderPerformCompleteView) {
        this.storeOrderPerformCompleteView = storeOrderPerformCompleteView;
        storeOrderPerformCompleteModel = new StoreOrderPerformCompleteModelImpl();
    }

    @Override
    public void saveStorePerformComplete() {
        if (storeOrderPerformCompleteView.getPerformId() == null || storeOrderPerformCompleteView.getPerformId() == -1) {
            storeOrderPerformCompleteView.getDataFail("数据错误，请重新登陆");
            return;
        }
        if (storeOrderPerformCompleteView.getPerformCompletePic().isEmpty()) {
            storeOrderPerformCompleteView.getDataFail("还没有上传完成图片");
            return;
        }
        if (storeOrderPerformCompleteView.getPerformCompleteContent().isEmpty()) {
            storeOrderPerformCompleteView.getDataFail("完成说明不能为空");
            return;
        }
        StoreOrderPerformCompleteBean params = new StoreOrderPerformCompleteBean();
        params.setPerformId(storeOrderPerformCompleteView.getPerformId());
        params.setCompletePic(storeOrderPerformCompleteView.getPerformCompletePic());
        params.setCompleteInfo(storeOrderPerformCompleteView.getPerformCompleteContent());
        storeOrderPerformCompleteModel.savePerformComplete(storeOrderPerformCompleteView.getContext(), params, new OnGetDataListener<StoreOrderPerformCompleteResultBean>() {
            @Override
            public void getDataSuccess(StoreOrderPerformCompleteResultBean result) {
                storeOrderPerformCompleteView.savePerformCompleteSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                storeOrderPerformCompleteView.savePerformCompleteFail(msg);
            }
        });
    }
}
