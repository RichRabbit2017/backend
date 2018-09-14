package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity
@Table(name="promotion")
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
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
		name="promotion_location"
		, joinColumns={
			@JoinColumn(name="promotion_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="location_id", nullable=false)
			}
		)
	private List<Location> locations;

	public Promotion() {
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