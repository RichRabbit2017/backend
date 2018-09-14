package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the inventory database table.
 * 
 */
@Entity
@Table(name="inventory")
@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String dealer;

	@Column(name="dealer_address", length=45)
	private String dealerAddress;

	@Column(name="dealer_mobile")
	private int dealerMobile;

	@Column(length=45)
	private String name;

	private int price;

	private int qty;

	//bi-directional many-to-one association to CleanerInventoryTx
	@OneToMany(mappedBy="inventory")
	private List<CleanerInventoryTx> cleanerInventoryTxs;

	public Inventory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDealer() {
		return this.dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public String getDealerAddress() {
		return this.dealerAddress;
	}

	public void setDealerAddress(String dealerAddress) {
		this.dealerAddress = dealerAddress;
	}

	public int getDealerMobile() {
		return this.dealerMobile;
	}

	public void setDealerMobile(int dealerMobile) {
		this.dealerMobile = dealerMobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public List<CleanerInventoryTx> getCleanerInventoryTxs() {
		return this.cleanerInventoryTxs;
	}

	public void setCleanerInventoryTxs(List<CleanerInventoryTx> cleanerInventoryTxs) {
		this.cleanerInventoryTxs = cleanerInventoryTxs;
	}

	public CleanerInventoryTx addCleanerInventoryTx(CleanerInventoryTx cleanerInventoryTx) {
		getCleanerInventoryTxs().add(cleanerInventoryTx);
		cleanerInventoryTx.setInventory(this);

		return cleanerInventoryTx;
	}

	public CleanerInventoryTx removeCleanerInventoryTx(CleanerInventoryTx cleanerInventoryTx) {
		getCleanerInventoryTxs().remove(cleanerInventoryTx);
		cleanerInventoryTx.setInventory(null);

		return cleanerInventoryTx;
	}

}