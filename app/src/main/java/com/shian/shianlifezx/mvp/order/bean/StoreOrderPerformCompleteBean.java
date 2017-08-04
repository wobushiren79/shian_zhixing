package com.shian.shianlifezx.mvp.order.bean;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class StoreOrderPerformCompleteBean extends BaseHttpParams {
    /**
     * 订单执行信息表ID
     */
    private Long performId;

    /**
     * 执行完成提交文字（多次提交服务完成时的文字）
     */
    private String completeInfo;

    /**
     * 执行完成提交图片（单次不超过3张，分列多次提交服务完成的照片，用，隔开）
     */
    private String completePic;

    public Long getPerformId() {
        return performId;
    }

    public void setPerformId(Long performId) {
        this.performId = performId;
    }

    public String getCompleteInfo() {
        return completeInfo;
    }

    public void setCompleteInfo(String completeInfo) {
        this.completeInfo = completeInfo;
    }

    public String getCompletePic() {
        return completePic;
    }

    public void setCompletePic(String completePic) {
        this.completePic = completePic;
    }
}
