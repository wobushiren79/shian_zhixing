package com.shian.shianlifezx.mvp.order.bean;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

import java.util.List;

/**
 * Created by zm.
 */

public class StoreOrderGetExecutorBean  extends BaseHttpParams {
    /**
     * 执行商家ID
     */
    private Long performUserId;

    public Long getPerformUserId() {
        return performUserId;
    }

    public void setPerformUserId(Long performUserId) {
        this.performUserId = performUserId;
    }


}
