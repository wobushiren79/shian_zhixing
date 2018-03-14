package com.shian.shianlifezx.mvp.order.presenter.impl;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.GoodsExpress;
import com.shian.shianlifezx.mvp.order.bean.GoodsPerform;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformResultBean;
import com.shian.shianlifezx.mvp.order.model.IStoreOrderSavePerformModel;
import com.shian.shianlifezx.mvp.order.model.impl.StoreOrderSavePerformModelImpl;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderSavePerformPresenter;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderSavePerformView;
import com.shian.shianlifezx.thisenum.GoodsPerformWayEnum;

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

        GoodsPerform goodsPerform = new GoodsPerform();
        if (storeOrderSavePerformView.getOrderId() == null
                || storeOrderSavePerformView.getOrderId() == -1
                || storeOrderSavePerformView.getPerformId() == null
                || storeOrderSavePerformView.getPerformId() == -1
                || storeOrderSavePerformView.getGoodsItemId() == null
                || storeOrderSavePerformView.getGoodsItemId() == -1) {
            storeOrderSavePerformView.getDataFail("提交数据异常，请退出重新登录");
            return;
        }
        if (storeOrderSavePerformView.getPerformWay() == null) {
            storeOrderSavePerformView.getDataFail("还没有填写执行方式");
            return;
        }
        if (storeOrderSavePerformView.getPerformWay() == GoodsPerformWayEnum.home_send.getCode()
                || storeOrderSavePerformView.getPerformWay() == GoodsPerformWayEnum.local_send.getCode()) {
            if (storeOrderSavePerformView.getPerformUserName().isEmpty()) {
                storeOrderSavePerformView.getDataFail("还没有填写执行人姓名");
                return;
            }
            if (storeOrderSavePerformView.getPerformUserPhone().isEmpty()) {
                storeOrderSavePerformView.getDataFail("还没有填写执行人电话");
                return;
            }
            goodsPerform.setPerformUserName(storeOrderSavePerformView.getPerformUserName());
            goodsPerform.setPerformUserPhone(storeOrderSavePerformView.getPerformUserPhone());
            goodsPerform.setPerformComment(storeOrderSavePerformView.getPerformComment());
        } else {
            if (storeOrderSavePerformView.getCourierNumber().isEmpty()) {
                storeOrderSavePerformView.getDataFail("还没有填写快递单号");
                return;
            }
            GoodsExpress goodsExpress = new GoodsExpress();
            goodsExpress.setExpressName(storeOrderSavePerformView.getCourierCompany());
            goodsExpress.setDeliveryNumber(storeOrderSavePerformView.getCourierNumber());
            params.setGoodsExpress(goodsExpress);
        }
        goodsPerform.setPerformWay(storeOrderSavePerformView.getPerformWay());
        goodsPerform.setId(storeOrderSavePerformView.getPerformId());
        goodsPerform.setOrderId(storeOrderSavePerformView.getOrderId());
        goodsPerform.setGoodsItemId(storeOrderSavePerformView.getGoodsItemId());

        params.setGoodsPerform(goodsPerform);

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
