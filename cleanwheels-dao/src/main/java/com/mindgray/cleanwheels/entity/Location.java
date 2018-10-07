package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@Table(name="location")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String city;

	@Column(length=45)
	private String society;

	@OneToMany(mappedBy="location")
	private List<Cleaner> cleaners;

	//bi-directional many-to-one association to LocationContractorTx
	@OneToMany(mappedBy="location")
	private List<LocationContractorTx> locationContractorTxs;

	//bi-directional many-to-many association to Package
	@ManyToMany(mappedBy="locations")
	private List<Package> packages;

	//bi-directional many-to-many association to Promotion
	@ManyToMany(mappedBy="locations")
	private List<Promotion> promotions;

	public Location() {
	}

	public Location(String city, String society) {
		this.city = city;
		this.society = society;
	}

	public int getId() {
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

	public String getSociety() {
		return this.society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public List<LocationContractorTx> getLocationContractorTxs() {
		return this.locationContractorTxs;
	}

	public void setLocationContractorTxs(List<LocationContractorTx> locationContractorTxs) {
		this.locationContractorTxs = locationContractorTxs;
	}

	public LocationContractorTx addLocationContractorTx(LocationContractorTx locationContractorTx) {
		getLocationContractorTxs().add(locationContractorTx);
		locationContractorTx.setLocation(this);

		return locationContractorTx;
	}

	public LocationContractorTx removeLocationContractorTx(LocationContractorTx locationContractorTx) {
		getLocationContractorTxs().remove(locationContractorTx);
		locationContractorTx.setLocation(null);

		return locationContractorTx;
	}

	public List<Package> getPackages() {
		return this.packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public List<Promotion> getPromotions() {
		return this.promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public List<Cleaner> getCleaners() {
		return cleaners;
	}

	public void setCleaners(List<Cleaner> cleaners) {
		this.cleaners = cleaners;
	}
}