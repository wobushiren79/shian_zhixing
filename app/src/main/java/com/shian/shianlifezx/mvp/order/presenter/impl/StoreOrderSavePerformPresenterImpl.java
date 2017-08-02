package com.shian.shianlifezx.mvp.order.presenter.impl;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderSavePerformModel;
import com.shian.shianlifezx.mvp.order.model.impl.StoreOrderSavePerformModelImpl;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderSavePerformPresenter;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderSavePerformView;

/**
 * Created by zm.
 */

public class StoreOrderSavePerformPresenterImpl implements IStoreOrderSavePerformPresenter {
    IStoreOrderSavePerformView storeOrderSavePerformView;
    IStoreOrderSavePerformModel storeOrderSavePerformModel;


    public StoreOrderSavePerformPresenterImpl(IStoreOrderSavePerformView storeOrderSavePerformView) {
        this.storeOrderSavePerformView = storeOrderSavePerformView;
        storeOrderSavePerformModel = new StoreOrderSavePerformModelImpl();
    }

    @Override
    public void savePerformInfo() {
        StoreOrderSavePerformBean params = new StoreOrderSavePerformBean();

        StoreOrderSavePerformBean.GoodsPerform goodsPerform = new StoreOrderSavePerformBean.GoodsPerform();
        if (storeOrderSavePerformView.getOrderId() == null
                || storeOrderSavePerformView.getOrderId() == -1
                || storeOrderSavePerformView.getPerformId() == null
                || storeOrderSavePerformView.getPerformId() == -1
                || storeOrderSavePerformView.getGoodsItemId() == null
                || storeOrderSavePerformView.getGoodsItemId() == -1) {
            storeOrderSavePerformView.getDataFail("提交数据异常，请退出重新登陆");
            return;
        }
        if (storeOrderSavePerformView.getPerformWay() == null) {
            storeOrderSavePerformView.getDataFail("还没有填写执行方式");
            return;
        }
        goodsPerform.setPerformWay(storeOrderSavePerformView.getPerformWay());
        goodsPerform.setId(storeOrderSavePerformView.getPerformId());
        goodsPerform.setOrderId(storeOrderSavePerformView.getOrderId());
        goodsPerform.setGoodsItemId(storeOrderSavePerformView.getGoodsItemId());
        goodsPerform.setPerformUserName(storeOrderSavePerformView.getPerformUserName());
        goodsPerform.setPerformUserPhone(storeOrderSavePerformView.getPerformUserPhone());
        goodsPerform.setPerformComment(storeOrderSavePerformView.getPerformComment());

        StoreOrderSavePerformBean.GoodsExpress goodsExpress = new StoreOrderSavePerformBean.GoodsExpress();
        goodsExpress.setExpressName(storeOrderSavePerformView.getCourierCompany());
        goodsExpress.setDeliveryNumber(storeOrderSavePerformView.getCourierNumber());

        params.setGoodsPerform(goodsPerform);
        params.setGoodsExpress(goodsExpress);
        storeOrderSavePerformModel.savePerformInfo(storeOrderSavePerformView.getContext(), params, new OnGetDataListener<StoreOrderSavePerformResultBean>() {
            @Override
            public void getDataSuccess(StoreOrderSavePerformResultBean result) {
                storeOrderSavePerformView.savePerformInfoSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                storeOrderSavePerformView.savePerformInfoFail(msg);
            }
        });
    }

}
