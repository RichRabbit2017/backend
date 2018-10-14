package com.mindgray.cleanwheels.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VehiclePackageTx {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable=false)
	private Package package1;

	@Column(nullable=false)
	private Location location;

	@Column(nullable=false)
	private Date packageCreationDate;

	@Column(nullable=false)
	private Date packageStartDate;

	@Column(nullable=false)
	private Date packageEndDate;

	@Column(nullable=false)
	private Vehicle vehicle;

	@Column(nullable=false)
	private boolean status;

	@Column(nullable=false)
	private Double actualAmount;

	private Double discountAmount;

	@Column(nullable=false)
	private Double finalAmount;
	
	@Column(nullable=false)
	private Integer subscriptionType;

	public VehiclePackageTx() {

	}

	public VehiclePackageTx(Package package1, Date packageCreationDate,
			Date packageStartDate, Date packageEndDate, Vehicle vehicle,
			boolean status, Double actualAmount, Double discountAmount,
			Double finalAmount, Integer subscriptionType) {
		super();
		this.package1 = package1;
		this.packageCreationDate = packageCreationDate;
		this.packageStartDate = packageStartDate;
		this.packageEndDate = packageEndDate;
		this.vehicle = vehicle;
		this.status = status;
		this.actualAmount = actualAmount;
		this.discountAmount = discountAmount;
		this.finalAmount = finalAmount;
		this.subscriptionType = subscriptionType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Package getPackage1() {
		return package1;
	}

	public void setPackage1(Package package1) {
		this.package1 = package1;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getPackageCreationDate() {
		return packageCreationDate;
	}

	public void setPackageCreationDate(Date packageCreationDate) {
		this.packageCreationDate = packageCreationDate;
	}

	public Date getPackageStartDate() {
		return packageStartDate;
	}

	public void setPackageStartDate(Date packageStartDate) {
		this.packageStartDate = packageStartDate;
	}

	public Date getPackageEndDate() {
		return packageEndDate;
	}

	public void setPackageEndDate(Date packageEndDate) {
		this.packageEndDate = packageEndDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Double getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(Double actualAmount) {
		this.actualAmount = actualAmount;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}

}
