package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the cleaner database table.
 * 
 */
@Entity
@Table(name="cleaner")
@NamedQuery(name="Cleaner.findAll", query="SELECT c FROM Cleaner c")
public class Cleaner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String address;

	@Column(length=45)
	private String adhaar;

	@Column(name="alternate_mobile")
	private int alternateMobile;

	private int mobile;

	@Column(length=45)
	private String name;

	@Column(length=45)
	private String pan;

	//bi-directional many-to-one association to CleanerInventoryTx
	@OneToMany(mappedBy="cleaner")
	private List<CleanerInventoryTx> cleanerInventoryTxs;

	//bi-directional many-to-one association to VehicleCleanerTx
	@OneToMany(mappedBy="cleaner")
	private List<VehicleCleanerTx> vehicleCleanerTxs;

	public Cleaner() {
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

	public String getAdhaar() {
		return this.adhaar;
	}

	public void setAdhaar(String adhaar) {
		this.adhaar = adhaar;
	}

	public int getAlternateMobile() {
		return this.alternateMobile;
	}

	public void setAlternateMobile(int alternateMobile) {
		this.alternateMobile = alternateMobile;
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

	public List<CleanerInventoryTx> getCleanerInventoryTxs() {
		return this.cleanerInventoryTxs;
	}

	public void setCleanerInventoryTxs(List<CleanerInventoryTx> cleanerInventoryTxs) {
		this.cleanerInventoryTxs = cleanerInventoryTxs;
	}

	public CleanerInventoryTx addCleanerInventoryTx(CleanerInventoryTx cleanerInventoryTx) {
		getCleanerInventoryTxs().add(cleanerInventoryTx);
		cleanerInventoryTx.setCleaner(this);

		return cleanerInventoryTx;
	}

	public CleanerInventoryTx removeCleanerInventoryTx(CleanerInventoryTx cleanerInventoryTx) {
		getCleanerInventoryTxs().remove(cleanerInventoryTx);
		cleanerInventoryTx.setCleaner(null);

		return cleanerInventoryTx;
	}

	public List<VehicleCleanerTx> getVehicleCleanerTxs() {
		return this.vehicleCleanerTxs;
	}

	public void setVehicleCleanerTxs(List<VehicleCleanerTx> vehicleCleanerTxs) {
		this.vehicleCleanerTxs = vehicleCleanerTxs;
	}

	public VehicleCleanerTx addVehicleCleanerTx(VehicleCleanerTx vehicleCleanerTx) {
		getVehicleCleanerTxs().add(vehicleCleanerTx);
		vehicleCleanerTx.setCleaner(this);

		return vehicleCleanerTx;
	}

	public VehicleCleanerTx removeVehicleCleanerTx(VehicleCleanerTx vehicleCleanerTx) {
		getVehicleCleanerTxs().remove(vehicleCleanerTx);
		vehicleCleanerTx.setCleaner(null);

		return vehicleCleanerTx;
	}

}