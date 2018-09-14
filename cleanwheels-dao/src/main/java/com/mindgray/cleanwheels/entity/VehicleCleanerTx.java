package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the vehicle_cleaner_tx database table.
 * 
 */
@Entity
@Table(name="vehicle_cleaner_tx")
@NamedQuery(name="VehicleCleanerTx.findAll", query="SELECT v FROM VehicleCleanerTx v")
public class VehicleCleanerTx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name="vehicle_id", nullable=false)
	private Vehicle vehicle;

	//bi-directional many-to-one association to Cleaner
	@ManyToOne
	@JoinColumn(name="cleaner_id", nullable=false)
	private Cleaner cleaner;

	public VehicleCleanerTx() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Cleaner getCleaner() {
		return this.cleaner;
	}

	public void setCleaner(Cleaner cleaner) {
		this.cleaner = cleaner;
	}

}