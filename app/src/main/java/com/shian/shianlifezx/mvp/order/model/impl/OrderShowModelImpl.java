package com.shian.shianlifezx.mvp.order.model.impl;


import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.order.bean.OrderShowResultBean;
import com.shian.shianlifezx.mvp.order.model.IOrderShowModel;
import com.shian.shianlifezx.thisenum.OrderItemShowEnum;
import com.shian.shianlifezx.thisenum.RoleEnum;

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

        if (AppContansts.systemLoginInfo != null) {
            for (String role : AppContansts.systemLoginInfo.getResourceCodes()) {
                if (role.equals(RoleEnum.Goods_Executor.getCode())) {
                    listData.add(getItem(OrderItemShowEnum.store));
                } else if (role.equals(RoleEnum.Funeral_Executor.getCode())) {
                    listData.add(getItem(OrderItemShowEnum.funeral));
                }
            }
        }


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
