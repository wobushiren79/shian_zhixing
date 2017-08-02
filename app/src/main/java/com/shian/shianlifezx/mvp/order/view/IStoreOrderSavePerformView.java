package com.shian.shianlifezx.mvp.order.view;

import android.content.Context;

import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderSavePerformView {

    Context getContext();

    void savePerformInfoSuccess(StoreOrderSavePerformResultBean resultBean);

    void savePerformInfoFail(String msg);

    Integer getPerformWay();

    /**
     * 获取快递公司
     */
    String getCourierCompany();

    /**
     * 获取快递编号
     */
    String getCourierNumber();

    /**
     * 获取订单ID
     *
     * @return
     */
    Long getOrderId();

    /**
     * 获取执行ID
     *
     * @return
     */
    Long getPerformId();

    /**
     * 获取商品表ID
     *
     * @return
     */
    Long getGoodsItemId();

    /**
     * 获取执行人名字
     * @return
     */
    String getPerformUserName();

    /**
     * 获取执行人电话
     * @return
     */
    String getPerformUserPhone();

    /**
     * 获取执行备注
     * @return
     */
    String getPerformComment();


    /**
     * 获取上传数据失败
     */
    void getDataFail(String msg);

}
