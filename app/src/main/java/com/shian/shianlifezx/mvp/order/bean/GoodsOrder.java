package com.shian.shianlifezx.mvp.order.bean;


import com.shian.shianlifezx.base.BaseEntity;

/**
 * Created by zm.
 */

public class GoodsOrder extends BaseEntity {
    private int orderStatus;
    private int orderChannel;
    private String customerName;
    private String customerPhone;
    private Long connectId;
    private String orderNumber;
    private String orderComment;
    private int needInvoice;
    private int auditStatus;
    private int allotAuditor;
    private Long auditorId;
    private Long customerReceiveId;
    private Long customerDistributeId;
    private Long financeId;
    private int totalPrice;
    private int checkOrder;
    private int showTotalPrice;
    private int waitAssignNum;

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(int orderChannel) {
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


    public int getNeedInvoice() {
        return needInvoice;
    }

    public void setNeedInvoice(int needInvoice) {
        this.needInvoice = needInvoice;
    }


    public int getAllotAuditor() {
        return allotAuditor;
    }

    public void setAllotAuditor(int allotAuditor) {
        this.allotAuditor = allotAuditor;
    }


    public Object getCustomerReceiveId() {
        return customerReceiveId;
    }


    public int getTotalPrice() {
        return totalPrice;
    }

    public int getCheckOrder() {
        return checkOrder;
    }

    public void setCheckOrder(int checkOrder) {
        this.checkOrder = checkOrder;
    }


    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
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

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getShowTotalPrice() {
        return showTotalPrice;
    }

    public void setShowTotalPrice(int showTotalPrice) {
        this.showTotalPrice = showTotalPrice;
    }

    public int getWaitAssignNum() {
        return waitAssignNum;
    }

    public void setWaitAssignNum(int waitAssignNum) {
        this.waitAssignNum = waitAssignNum;
    }
}
