package com.mindgray.cleanwheels.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AddOnPackage implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name="package_id")
	private Package package1;

	
	
	private Integer air;
	
	private Integer waxInt;
	
	private Integer waxExt;
	
	private Integer vaccum;

	public AddOnPackage() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Package getPackage1() {
		return package1;
	}

	public void setPackage1(Package package1) {
		this.package1 = package1;
	}

	public Integer getAir() {
		return air;
	}

	public void setAir(Integer air) {
		this.air = air;
	}

	public Integer getWaxInt() {
		return waxInt;
	}

	public void setWaxInt(Integer waxInt) {
		this.waxInt = waxInt;
	}

	public Integer getWaxExt() {
		return waxExt;
	}

	public void setWaxExt(Integer waxExt) {
		this.waxExt = waxExt;
	}

	public Integer getVaccum() {
		return vaccum;
	}

	public void setVaccum(Integer vaccum) {
		this.vaccum = vaccum;
	}
}
