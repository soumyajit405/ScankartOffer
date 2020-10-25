package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the all_inventory_tx database table.
 * 
 */
@Entity
@Table(name="all_inventory_tx")
@NamedQuery(name="AllInventoryTx.findAll", query="SELECT a FROM AllInventoryTx a")
public class AllInventoryTx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="inventory_date")
	private Timestamp inventoryDate;

	private int quantity;

	//bi-directional many-to-one association to AllInventory
	@ManyToOne
	@JoinColumn(name="all_inventory_id")
	private AllInventory allInventory;

	public AllInventoryTx() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getInventoryDate() {
		return this.inventoryDate;
	}

	public void setInventoryDate(Timestamp inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public AllInventory getAllInventory() {
		return this.allInventory;
	}

	public void setAllInventory(AllInventory allInventory) {
		this.allInventory = allInventory;
	}

}