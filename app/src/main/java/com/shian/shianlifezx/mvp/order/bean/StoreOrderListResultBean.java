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

    public static class GoodsOrderItem {
        /**
         * 订单ID
         */
        private Long orderId;

        /**
         * 规格商品ID
         */
        private Long goodsId;

        /**
         * 规格商品ID
         */
        private Long goodsSpecId;

        /**
         * 分类属性ID
         */
        private Long classifyAttrId;

        /**
         * 分类ID
         */
        private Long classifyId;

        /**
         * 规格商品下单单价
         */
        private Integer specOrderedPrice;

        /**
         * 规格商品下单数量
         */
        private Integer specOrderedNum;

        /**
         * 规格商品下单名称
         */
        private String specOrderedVolume;

        /**
         * 规格商品代名词(类型)
         */
        private String specAlias;

        /**
         * 当前折扣率
         */
        private String currentDiscount;

        /**
         * 总计
         */
        private Integer specTotal;
        /**
         * 商品分类属性名称
         */
        private String specOrderedAttr;

        public String getSpecOrderedAttr() {
            return specOrderedAttr;
        }

        public void setSpecOrderedAttr(String specOrderedAttr) {
            this.specOrderedAttr = specOrderedAttr;
        }

        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }

        public Long getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Long goodsId) {
            this.goodsId = goodsId;
        }

        public Long getGoodsSpecId() {
            return goodsSpecId;
        }

        public void setGoodsSpecId(Long goodsSpecId) {
            this.goodsSpecId = goodsSpecId;
        }

        public Long getClassifyAttrId() {
            return classifyAttrId;
        }

        public void setClassifyAttrId(Long classifyAttrId) {
            this.classifyAttrId = classifyAttrId;
        }

        public Long getClassifyId() {
            return classifyId;
        }

        public void setClassifyId(Long classifyId) {
            this.classifyId = classifyId;
        }

        public Integer getSpecOrderedPrice() {
            return specOrderedPrice;
        }

        public void setSpecOrderedPrice(Integer specOrderedPrice) {
            this.specOrderedPrice = specOrderedPrice;
        }

        public Integer getSpecOrderedNum() {
            return specOrderedNum;
        }

        public void setSpecOrderedNum(Integer specOrderedNum) {
            this.specOrderedNum = specOrderedNum;
        }

        public String getSpecOrderedVolume() {
            return specOrderedVolume;
        }

        public void setSpecOrderedVolume(String specOrderedVolume) {
            this.specOrderedVolume = specOrderedVolume;
        }

        public String getSpecAlias() {
            return specAlias;
        }

        public void setSpecAlias(String specAlias) {
            this.specAlias = specAlias;
        }

        public String getCurrentDiscount() {
            return currentDiscount;
        }

        public void setCurrentDiscount(String currentDiscount) {
            this.currentDiscount = currentDiscount;
        }

        public Integer getSpecTotal() {
            return specTotal;
        }

        public void setSpecTotal(Integer specTotal) {
            this.specTotal = specTotal;
        }
    }

    public static class GoodsPerform {
        /**
         * 执行商品ID
         */
        private Long goodsItemId;
        /**
         * orderId
         */
        private Long orderId;
        /**
         * 执行状态:0待派单 1已派单(待接单) 2待执行(已接单) 3执行中  4审核中  5成功服务
         */
        private Integer performStatus;

        /**
         * 执行单编号
         */
        private String performSheetName;

        /**
         * 商家id
         */
        private Long performUserId;

        /**
         * 接单时间
         */
        private String acceptTime;

        /**
         * 开始服务时间
         */
        private String startTime;
        /**
         * 结束服务时间
         */
        private String endTime;

        /**
         * 执行方式:0同城送达 1上门服务 2快递物流
         */
        private Integer performWay;

        /**
         * 执行人姓名
         */
        private String performUserName;

        /**
         * 执行人电话
         */
        private String performUserPhone;

        /**
         * 执行备注
         */
        private String performComment;

        public Long getGoodsItemId() {
            return goodsItemId;
        }

        public void setGoodsItemId(Long goodsItemId) {
            this.goodsItemId = goodsItemId;
        }

        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }

        public Integer getPerformStatus() {
            return performStatus;
        }

        public void setPerformStatus(Integer performStatus) {
            this.performStatus = performStatus;
        }

        public String getPerformSheetName() {
            return performSheetName;
        }

        public void setPerformSheetName(String performSheetName) {
            this.performSheetName = performSheetName;
        }

        public Long getPerformUserId() {
            return performUserId;
        }

        public void setPerformUserId(Long performUserId) {
            this.performUserId = performUserId;
        }

        public String getAcceptTime() {
            return acceptTime;
        }

        public void setAcceptTime(String acceptTime) {
            this.acceptTime = acceptTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public Integer getPerformWay() {
            return performWay;
        }

        public void setPerformWay(Integer performWay) {
            this.performWay = performWay;
        }

        public String getPerformUserName() {
            return performUserName;
        }

        public void setPerformUserName(String performUserName) {
            this.performUserName = performUserName;
        }

        public String getPerformUserPhone() {
            return performUserPhone;
        }

        public void setPerformUserPhone(String performUserPhone) {
            this.performUserPhone = performUserPhone;
        }

        public String getPerformComment() {
            return performComment;
        }

        public void setPerformComment(String performComment) {
            this.performComment = performComment;
        }
    }

    public static class GoodsOrder {
        /**
         * 订单状态 0, 代付款或者待支付 值：1, 待服务  2,执行中  3,服务完成 4,成功服务  10,取消订单
         */
        private Integer orderStatus;

        /**
         * 订单来源渠道 值：0,顾问APP  1,客户小程序
         */
        private Integer orderChannel;

        /**
         * 客户姓名
         */
        private String customerName;

        /**
         * 客户电话
         */
        private String customerPhone;


        /**
         * 关联人open_id(微信Open_id)
         */
        private Long connectId;

        /**
         * 订单编号
         */
        private String orderNumber;

        /**
         * 下单备注
         */
        private String orderComment;

        /**
         * 是否需要发票 值：1：需要发票  0：不需要发票
         */
        private Integer needInvoice;

        /**
         * 审核状态 0.无效,1有效
         */
        private Integer auditStatus;

        /**
         * 是否分配了审核员:0未分配    1已分配
         */
        private Integer allotAuditor;

        /**
         * 审核员id
         */
        private Long auditorId;

        /**
         * 平台接件客服id
         */
        private Long customerReceiveId;

        /**
         * 平台派单客服id
         */
        private Long customerDistributeId;

        /**
         * 平台财务id
         */
        private Long financeId;

        /**
         * 客户订单总金额
         */
        private Integer totalPrice;
        /**
         * 确认定单（0未确认，1确认）
         */
        private Integer checkOrder;

        /**
         * 顾问订单总金额
         */
        private Integer showTotalPrice;

        public Integer getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(Integer orderStatus) {
            this.orderStatus = orderStatus;
        }

        public Integer getOrderChannel() {
            return orderChannel;
        }

        public void setOrderChannel(Integer orderChannel) {
            this.orderChannel = orderChannel;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerPhone() {
            return customerPhone;
        }

        public void setCustomerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
        }

        public Long getConnectId() {
            return connectId;
        }

        public void setConnectId(Long connectId) {
            this.connectId = connectId;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public String getOrderComment() {
            return orderComment;
        }

        public void setOrderComment(String orderComment) {
            this.orderComment = orderComment;
        }

        public Integer getNeedInvoice() {
            return needInvoice;
        }

        public void setNeedInvoice(Integer needInvoice) {
            this.needInvoice = needInvoice;
        }

        public Integer getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(Integer auditStatus) {
            this.auditStatus = auditStatus;
        }

        public Integer getAllotAuditor() {
            return allotAuditor;
        }

        public void setAllotAuditor(Integer allotAuditor) {
            this.allotAuditor = allotAuditor;
        }

        public Long getAuditorId() {
            return auditorId;
        }

        public void setAuditorId(Long auditorId) {
            this.auditorId = auditorId;
        }

        public Long getCustomerReceiveId() {
            return customerReceiveId;
        }

        public void setCustomerReceiveId(Long customerReceiveId) {
            this.customerReceiveId = customerReceiveId;
        }

        public Long getCustomerDistributeId() {
            return customerDistributeId;
        }

        public void setCustomerDistributeId(Long customerDistributeId) {
            this.customerDistributeId = customerDistributeId;
        }

        public Long getFinanceId() {
            return financeId;
        }

        public void setFinanceId(Long financeId) {
            this.financeId = financeId;
        }

        public Integer getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Integer totalPrice) {
            this.totalPrice = totalPrice;
        }

        public Integer getCheckOrder() {
            return checkOrder;
        }

        public void setCheckOrder(Integer checkOrder) {
            this.checkOrder = checkOrder;
        }

        public Integer getShowTotalPrice() {
            return showTotalPrice;
        }

        public void setShowTotalPrice(Integer showTotalPrice) {
            this.showTotalPrice = showTotalPrice;
        }
    }

    public static class GoodsServiceInfo {
        /**
         * 订单ID
         */
        private Long orderId;

        /**
         * 服务方式(0,及时服务 1,预约服务 2自提)
         */
        private Integer serviceWay;

        /**
         * 自提点
         */
        private String selfDelivery;

        /**
         * 自提点时间
         */
        private String selfDeliveryTime;

        /**
         * 预约服务时间
         */
        private String bookTime;

        /**
         * 联系人
         */
        private String contact;

        /**
         * 电话
         */
        private String contactPhone;

        /**
         * 服务地址
         */
        private String serviceLocation;

        /**
         * 创建时间
         */
        private String createdAt;


        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }

        public Integer getServiceWay() {
            return serviceWay;
        }

        public void setServiceWay(Integer serviceWay) {
            this.serviceWay = serviceWay;
        }

        public String getSelfDelivery() {
            return selfDelivery;
        }

        public void setSelfDelivery(String selfDelivery) {
            this.selfDelivery = selfDelivery;
        }

        public String getSelfDeliveryTime() {
            return selfDeliveryTime;
        }

        public void setSelfDeliveryTime(String selfDeliveryTime) {
            this.selfDeliveryTime = selfDeliveryTime;
        }

        public String getBookTime() {
            return bookTime;
        }

        public void setBookTime(String bookTime) {
            this.bookTime = bookTime;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getContactPhone() {
            return contactPhone;
        }

        public void setContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
        }

        public String getServiceLocation() {
            return serviceLocation;
        }

        public void setServiceLocation(String serviceLocation) {
            this.serviceLocation = serviceLocation;
        }
    }
}
