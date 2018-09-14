package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the cleaner_inventory_tx database table.
 * 
 */
@Entity
@Table(name="cleaner_inventory_tx")
@NamedQuery(name="CleanerInventoryTx.findAll", query="SELECT c FROM CleanerInventoryTx c")
public class CleanerInventoryTx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String comments;

	@Column(name="item_name", length=45)
	private String itemName;

	@Column(name="item_qty")
	private int itemQty;

	@Column(name="item_status", length=45)
	private String itemStatus;

	//bi-directional many-to-one association to Cleaner
	@ManyToOne
	@JoinColumn(name="cleaner_id", nullable=false)
	private Cleaner cleaner;

	//bi-directional many-to-one association to Inventory
	@ManyToOne
	@JoinColumn(name="inventory_id", nullable=false)
	private Inventory inventory;

	public CleanerInventoryTx() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQty() {
		return this.itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public String getItemStatus() {
		return this.itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Cleaner getCleaner() {
		return this.cleaner;
	}

	public void setCleaner(Cleaner cleaner) {
		this.cleaner = cleaner;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}