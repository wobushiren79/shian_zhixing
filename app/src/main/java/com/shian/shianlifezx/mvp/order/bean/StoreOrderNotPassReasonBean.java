package com.shian.shianlifezx.mvp.order.bean;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class StoreOrderNotPassReasonBean extends BaseHttpParams {
    private Long performId;

    public Long getPerformId() {
        return performId;
    }

    public void setPerformId(Long performId) {
        this.performId = performId;
    }
}
