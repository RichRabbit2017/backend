package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the package database table.
 * 
 */
@Entity
@Table(name="package")
@NamedQuery(name="Package.findAll", query="SELECT p FROM Package p")
public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String name;

	//bi-directional many-to-many association to Location
	@ManyToMany
	@JoinTable(
		name="package_location"
		, joinColumns={
			@JoinColumn(name="package_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="location_id", nullable=false)
			}
		)
	private List<Location> locations;

	public Package() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

}