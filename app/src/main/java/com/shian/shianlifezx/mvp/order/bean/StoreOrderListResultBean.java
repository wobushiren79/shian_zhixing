package com.shian.shianlifezx.mvp.order.bean;

import java.util.List;

/**
 * Created by zm.
 */

public class StoreOrderListResultBean {
    private int pageSize; //每页显示记录数
    private int pageNumber;    //当前页
    private List<Content> content;


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

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public static class Content {
        private Long id;
        private GoodsOrderItem goodsOrderItem; //商品详情
        private GoodsPerform goodsPerform; //执行详情
        private GoodsOrder goodsOrder;//订单详情
        private GoodsServiceInfo goodsServiceInfo;//服务信息

        public GoodsServiceInfo getGoodsServiceInfo() {
            return goodsServiceInfo;
        }

        public void setGoodsServiceInfo(GoodsServiceInfo goodsServiceInfo) {
            this.goodsServiceInfo = goodsServiceInfo;
        }

        public GoodsOrder getGoodsOrder() {
            return goodsOrder;
        }

        public void setGoodsOrder(GoodsOrder goodsOrder) {
            this.goodsOrder = goodsOrder;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public GoodsOrderItem getGoodsOrderItem() {
            return goodsOrderItem;
        }

        public void setGoodsOrderItem(GoodsOrderItem goodsOrderItem) {
            this.goodsOrderItem = goodsOrderItem;
        }

        public GoodsPerform getGoodsPerform() {
            return goodsPerform;
        }

        public void setGoodsPerform(GoodsPerform goodsPerform) {
            this.goodsPerform = goodsPerform;
        }
    }

}
