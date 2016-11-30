package com.shian.shianlifezx.provide.result;

import java.util.List;

import com.shian.shianlifezx.provide.params.HpSaveCustomerContract;

public class WaitItem {
    private long itemApplyTime;
    private long acceptTime;
    private String adviserName;
    private long applyTime;
    private long assignId;
    private String ctgName;
    private String funeralAddress;
    private int itemStatus;
    private String note;
    private int number;
    private long orderItemId;
    private long passTime;
    private long passUnTime;
    private boolean showAcceptOrRejectFlag;
    private boolean showStartServiceFlag;
    private String skuName;
    private String skuUnit;
    private long startTime;
    private long endTime;
    private String adviserMobile;
    String specification;
    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    private List<HpSaveCustomerContract.AddAddition> itemAdditions;


    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getAdviserMobile() {
        return adviserMobile;
    }

    public void setAdviserMobile(String adviserMobile) {
        this.adviserMobile = adviserMobile;
    }

    public List<HpSaveCustomerContract.AddAddition> getItemAdditions() {
        return itemAdditions;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setItemAdditions(List<HpSaveCustomerContract.AddAddition> itemAdditions) {
        this.itemAdditions = itemAdditions;
    }

    public long getItemApplyTime() {
        return itemApplyTime;
    }

    public void setItemApplyTime(long itemApplyTime) {
        this.itemApplyTime = itemApplyTime;
    }

    public long getAcceptTime() {
        return this.acceptTime;
    }

    public String getAdviserName() {
        return this.adviserName;
    }

    public long getApplyTime() {
        return this.applyTime;
    }

    public long getAssignId() {
        return this.assignId;
    }

    public String getCtgName() {
        return this.ctgName;
    }

    public String getFuneralAddress() {
        return this.funeralAddress;
    }

    public int getItemStatus() {
        return this.itemStatus;
    }

    public String getNote() {
        return this.note;
    }

    public int getNumber() {
        return this.number;
    }

    public long getOrderItemId() {
        return this.orderItemId;
    }

    public long getPassTime() {
        return this.passTime;
    }

    public long getPassUnTime() {
        return this.passUnTime;
    }

    public String getSkuName() {
        return this.skuName;
    }

    public String getSkuUnit() {
        return this.skuUnit;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public boolean isShowAcceptOrRejectFlag() {
        return this.showAcceptOrRejectFlag;
    }

    public boolean isShowStartServiceFlag() {
        return this.showStartServiceFlag;
    }

    public void setAcceptTime(long paramLong) {
        this.acceptTime = paramLong;
    }

    public void setAdviserName(String paramString) {
        this.adviserName = paramString;
    }

    public void setApplyTime(long paramLong) {
        this.applyTime = paramLong;
    }

    public void setAssignId(long paramLong) {
        this.assignId = paramLong;
    }

    public void setCtgName(String paramString) {
        this.ctgName = paramString;
    }

    public void setFuneralAddress(String paramString) {
        this.funeralAddress = paramString;
    }

    public void setItemStatus(int paramInt) {
        this.itemStatus = paramInt;
    }

    public void setNote(String paramString) {
        this.note = paramString;
    }

    public void setNumber(int paramInt) {
        this.number = paramInt;
    }

    public void setOrderItemId(long paramLong) {
        this.orderItemId = paramLong;
    }

    public void setPassTime(long paramLong) {
        this.passTime = paramLong;
    }

    public void setPassUnTime(long paramLong) {
        this.passUnTime = paramLong;
    }

    public void setShowAcceptOrRejectFlag(boolean paramBoolean) {
        this.showAcceptOrRejectFlag = paramBoolean;
    }

    public void setShowStartServiceFlag(boolean paramBoolean) {
        this.showStartServiceFlag = paramBoolean;
    }

    public void setSkuName(String paramString) {
        this.skuName = paramString;
    }

    public void setSkuUnit(String paramString) {
        this.skuUnit = paramString;
    }

    public void setStartTime(long paramLong) {
        this.startTime = paramLong;
    }
}

/*
 * Location: F:\software\dex2jar-0.0.9.9\classes_dex2jar.jar Qualified Name:
 * com.shian.shianlifezx.provide.result.WaitItem JD-Core Version: 0.6.0
 */