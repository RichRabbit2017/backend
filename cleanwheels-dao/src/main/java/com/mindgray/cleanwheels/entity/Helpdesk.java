package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the helpdesk database table.
 * 
 */
@Entity
@Table(name="helpdesk")
@NamedQuery(name="Helpdesk.findAll", query="SELECT h FROM Helpdesk h")
public class Helpdesk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String comment;

	@Column(length=45)
	private String resolution;

	@Column(name="ticket_type", length=45)
	private String ticketType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name="vehicle_id", nullable=false)
	private Vehicle vehicle;

	public Helpdesk() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getResolution() {
		return this.resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getTicketType() {
		return this.ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}