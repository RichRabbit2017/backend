package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the contractor database table.
 * 
 */
@Entity
@Table(name="contractor")
@NamedQuery(name="Contractor.findAll", query="SELECT c FROM Contractor c")
public class Contractor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String address;

	@Column(name="alternate_mobile")
	private int alternateMobile;

	@Column(length=45)
	private String bank;

	@Column(name="bank_account", length=45)
	private String bankAccount;

	@Column(name="bank_ifsc", length=45)
	private String bankIfsc;

	private int mobile;

	@Column(length=45)
	private String name;

	@Column(length=45)
	private String pan;

	//bi-directional many-to-one association to LocationContractorTx
	@OneToMany(mappedBy="contractor")
	private List<LocationContractorTx> locationContractorTxs;

	public Contractor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAlternateMobile() {
		return this.alternateMobile;
	}

	public void setAlternateMobile(int alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankIfsc() {
		return this.bankIfsc;
	}

	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}

	public int getMobile() {
		return this.mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public List<LocationContractorTx> getLocationContractorTxs() {
		return this.locationContractorTxs;
	}

	public void setLocationContractorTxs(List<LocationContractorTx> locationContractorTxs) {
		this.locationContractorTxs = locationContractorTxs;
	}

	public LocationContractorTx addLocationContractorTx(LocationContractorTx locationContractorTx) {
		getLocationContractorTxs().add(locationContractorTx);
		locationContractorTx.setContractor(this);

		return locationContractorTx;
	}

	public LocationContractorTx removeLocationContractorTx(LocationContractorTx locationContractorTx) {
		getLocationContractorTxs().remove(locationContractorTx);
		locationContractorTx.setContractor(null);

		return locationContractorTx;
	}

}