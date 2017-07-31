package com.shian.shianlifezx.mvp.order.bean;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

import java.util.List;

/**
 * Created by zm.
 */

public class StoreOrderBean extends BaseHttpParams {
    private int pageSize; //每页显示记录数
    private int pageNumber; //当前页
    private Content content;//内容


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public static class Content {
        private List<Integer> status;//订单状态
        private Long performerId; //执行人ID

        public List<Integer> getStatus() {
            return status;
        }

        public void setStatus(List<Integer> status) {
            this.status = status;
        }

        public Long getPerformerId() {
            return performerId;
        }

        public void setPerformerId(Long performerId) {
            this.performerId = performerId;
        }
    }
}
