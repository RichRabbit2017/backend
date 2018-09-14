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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=45)
	private String city;

	@Column(name="flat_no", length=45)
	private String flatNo;

	@Column(name="mobile", unique=true)
	private Integer mobile;

	@Column(length=45)
	private String name;

	@Column(name="parking_no", length=45)
	private String parkingNo;

	@Column(nullable=false, length=45)
	private String password;

	@Column(nullable=false, length=45, unique=true)
	private String email;

	@Column(length=45)
	private String sector;

	@Column(length=45)
	private String society;

	@Column(length=45)
	private String username;

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
		this.username =username;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Integer getMobile() {
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
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