package com.mindgray.cleanwheels.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@Table(name = "vehicle")
@NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(length = 45)
	private String category;

	@Column(length = 45)
	private String name;

	@Column(length = 45, unique=true)
	private String num;

	@Column(length = 45)
	private String type;

	@Column(length = 45)
	private String parkingNo;

	// bi-directional many-to-one association to Helpdesk
	@OneToMany(mappedBy = "vehicle")
	private List<Helpdesk> helpdesks;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// bi-directional many-to-one association to VehicleCleanerTx
	@OneToMany(mappedBy = "vehicle")
	private List<VehicleCleanerTx> vehicleCleanerTxs;

	public Vehicle() {

	}

	public Vehicle(String parkingNo, String vechileNo, String vehicleCategory,
			String vehicleType, User user) {
		super();
		this.parkingNo = parkingNo;
		this.category = vehicleCategory;
		this.num = vechileNo;
		this.type = vehicleType;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Helpdesk> getHelpdesks() {
		return this.helpdesks;
	}

	public void setHelpdesks(List<Helpdesk> helpdesks) {
		this.helpdesks = helpdesks;
	}

	public Helpdesk addHelpdesk(Helpdesk helpdesk) {
		getHelpdesks().add(helpdesk);
		helpdesk.setVehicle(this);

		return helpdesk;
	}

	public Helpdesk removeHelpdesk(Helpdesk helpdesk) {
		getHelpdesks().remove(helpdesk);
		helpdesk.setVehicle(null);

		return helpdesk;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<VehicleCleanerTx> getVehicleCleanerTxs() {
		return this.vehicleCleanerTxs;
	}

	public void setVehicleCleanerTxs(List<VehicleCleanerTx> vehicleCleanerTxs) {
		this.vehicleCleanerTxs = vehicleCleanerTxs;
	}

	public String getParkingNo() {
		return parkingNo;
	}

	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}

	public VehicleCleanerTx addVehicleCleanerTx(
			VehicleCleanerTx vehicleCleanerTx) {
		getVehicleCleanerTxs().add(vehicleCleanerTx);
		vehicleCleanerTx.setVehicle(this);

		return vehicleCleanerTx;
	}

	public VehicleCleanerTx removeVehicleCleanerTx(
			VehicleCleanerTx vehicleCleanerTx) {
		getVehicleCleanerTxs().remove(vehicleCleanerTx);
		vehicleCleanerTx.setVehicle(null);

		return vehicleCleanerTx;
	}

}