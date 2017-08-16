package com.shian.shianlifezx.mvp.order.bean;


import com.shian.shianlifezx.base.BaseEntity;

/**
 * Created by zm.
 */

public class GoodsServiceInfo extends BaseEntity {
    private int orderId;
    private int serviceWay;
    private String selfDelivery;
    private String selfDeliveryTime;
    private String bookTime;
    private String contact;
    private String contactPhone;
    private String serviceLocation;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getServiceWay() {
        return serviceWay;
    }

    public void setServiceWay(int serviceWay) {
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
