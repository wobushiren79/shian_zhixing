package com.shian.shianlifezx.mvp.order.bean;


import com.shian.shianlifezx.base.BaseEntity;

import java.util.Date;


/** 
 * 类名称：GoodsPerformCancel 实体
 * 创建人： CQ
 * 创建时间：2017-08-21
 */

public class GoodsPerformCancel extends BaseEntity {


	/**
	 * 执行单ID
	 */
    private Long performId;

	/**
	 * 取消执行单时间
	 */
    private Date cancelTime;

	/**
	 * 取消执行单原因
	 */
    private String cancelReason;

	/**
	 * 取消订单类型:0退货、1退款、2退货退款 3其他
	 */
    private Integer cancelResult;

	/**
	 * 取消执行单的状态 值: 1取消中 2拒绝取消 3取消成功
	 */
    private Integer cancelStatus;

	/**
	 * 取消备注
	 */
    private String cancelRemark;

	/**
	 * 处理意见
	 */
    private String handleIdea;

	/**
	 * 审批人
	 */
    private Long cancelAudit;

	/**
	 * 审批时间
	 */
    private Date cancelAuditTime;

	/**
	 * 申请人
	 */
	private String applyer;

	/**
	 * 申请人电话
	 */
	private String applyerPhone;


	public Long getPerformId() {
		return performId;
	}

	public void setPerformId(Long performId) {
		this.performId = performId;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Integer getCancelResult() {
		return cancelResult;
	}

	public void setCancelResult(Integer cancelResult) {
		this.cancelResult = cancelResult;
	}

	public Integer getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(Integer cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public String getCancelRemark() {
		return cancelRemark;
	}

	public void setCancelRemark(String cancelRemark) {
		this.cancelRemark = cancelRemark;
	}

	public String getHandleIdea() {
		return handleIdea;
	}

	public void setHandleIdea(String handleIdea) {
		this.handleIdea = handleIdea;
	}

	public Long getCancelAudit() {
		return cancelAudit;
	}

	public void setCancelAudit(Long cancelAudit) {
		this.cancelAudit = cancelAudit;
	}

	public Date getCancelAuditTime() {
		return cancelAuditTime;
	}

	public void setCancelAuditTime(Date cancelAuditTime) {
		this.cancelAuditTime = cancelAuditTime;
	}

	public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

	public String getApplyerPhone() {
		return applyerPhone;
	}

	public void setApplyerPhone(String applyerPhone) {
		this.applyerPhone = applyerPhone;
	}
}
