package com.mindgray.cleanwheels.dto;

import java.io.Serializable;
import java.util.Date;

public class BookServiceRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer packageId;

	private Integer vehicleId;

	private Date createdDate;

	private Date startDate;

	private Date endDate;

	private Integer subscriptionType;

	private Double amount;
	
	private String voucherCode;
	
	public BookServiceRequestDto() {

	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	
	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(Integer subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
}
