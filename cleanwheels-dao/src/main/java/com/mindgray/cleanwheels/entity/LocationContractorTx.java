package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the location_contractor_tx database table.
 * 
 */
@Entity
@Table(name="location_contractor_tx")
@NamedQuery(name="LocationContractorTx.findAll", query="SELECT l FROM LocationContractorTx l")
public class LocationContractorTx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="location_id", nullable=false)
	private Location location;

	//bi-directional many-to-one association to Contractor
	@ManyToOne
	@JoinColumn(name="contractor_id", nullable=false)
	private Contractor contractor;

	public LocationContractorTx() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Contractor getContractor() {
		return this.contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

}