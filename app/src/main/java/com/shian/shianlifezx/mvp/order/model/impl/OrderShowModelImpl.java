package com.shian.shianlifezx.mvp.order.model.impl;




import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.OrderShowResultBean;
import com.shian.shianlifezx.mvp.order.model.IOrderShowModel;
import com.shian.shianlifezx.thisenum.OrderItemShowEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zm.
 */

public class OrderShowModelImpl implements IOrderShowModel {

    @Override
    public void getOrderShowItems(OnGetDataListener<OrderShowResultBean> listener) {
        OrderShowResultBean resultBean = new OrderShowResultBean();
        List<OrderShowResultBean.Item> listData = new ArrayList<>();


        listData.add(getItem(OrderItemShowEnum.funeral));
        listData.add(getItem(OrderItemShowEnum.store));

        
        resultBean.setList(listData);
        listener.getDataSuccess(resultBean);
    }

    private OrderShowResultBean.Item getItem(OrderItemShowEnum itemShowEnum) {
        OrderShowResultBean.Item item = new OrderShowResultBean.Item();
        item.setName(itemShowEnum.getName());
        item.setPicId(itemShowEnum.getItemPic());
        item.setIntentClass(itemShowEnum.getIntentClass());
        return item;
    }
}
