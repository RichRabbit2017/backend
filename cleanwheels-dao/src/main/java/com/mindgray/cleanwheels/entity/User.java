package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id",length=45)
	private String userId;

	@Column(length=45)
	private String f_name;

	@Column(length=45)
	private String l_name;

	@Column(nullable=false, length=50, unique=true)
	private String email;

	@Column(name="mobile", unique=true)
	private Integer mobile;

	@Column(length=45)
	private String city;

	@Column(length=45)
	private String sector;

	@Column(length=45)
	private String society;

	@Column(name="flat_no", length=45)
	private String flatNo;

	@Column(name="parking_no", length=45)
	private String parkingNo;

	@Column(nullable=false, length=45)
	private String password;

	//bi-directional many-to-one association to Helpdesk
	@OneToMany(mappedBy="user")
	private List<Helpdesk> helpdesks;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="user")
	private List<Vehicle> vehicles;

	public User() {
	
	}
	
	public User(String password) {
		this.password = password;
	}
	
	
	public User(int mobileNumber,String email,String password, String username) {
		this.mobile = mobileNumber;
		this.password = password;
		this.email = email;
		this.userId =username;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFlatNo() {
		return this.flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMobile() {
		return this.mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getF_name() {
		return this.f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getParkingNo() {
		return this.parkingNo;
	}

	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getSociety() {
		return this.society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public String getUser_id() {
		return this.userId;
	}

	public void setUser_id(String user_id) {
		this.userId = user_id;
	}

	public List<Helpdesk> getHelpdesks() {
		return this.helpdesks;
	}

	public void setHelpdesks(List<Helpdesk> helpdesks) {
		this.helpdesks = helpdesks;
	}

	public Helpdesk addHelpdesk(Helpdesk helpdesk) {
		getHelpdesks().add(helpdesk);
		helpdesk.setUser(this);

		return helpdesk;
	}

	public Helpdesk removeHelpdesk(Helpdesk helpdesk) {
		getHelpdesks().remove(helpdesk);
		helpdesk.setUser(null);

		return helpdesk;
	}

	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		getVehicles().add(vehicle);
		vehicle.setUser(this);

		return vehicle;
	}

	public Vehicle removeVehicle(Vehicle vehicle) {
		getVehicles().remove(vehicle);
		vehicle.setUser(null);

		return vehicle;
	}

}