package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the all_inventory_attr database table.
 * 
 */
@Entity
@Table(name="all_inventory_attr")
@NamedQuery(name="AllInventoryAttr.findAll", query="SELECT a FROM AllInventoryAttr a")
public class AllInventoryAttr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String value;

	//bi-directional many-to-one association to All_Inventory_attr_pl
	@ManyToOne
	@JoinColumn(name="all_Inventory_attr_pl_id")
	private AllInventoryAttrPl allInventoryAttrPl;

	//bi-directional many-to-one association to AllInventory
	@ManyToOne
	@JoinColumn(name="all_inventory_id")
	private AllInventory allInventory;

	public AllInventoryAttr() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public AllInventoryAttrPl getAllInventoryAttrPl() {
		return this.allInventoryAttrPl;
	}

	public void setAllInventoryAttrPl(AllInventoryAttrPl allInventoryAttrPl) {
		this.allInventoryAttrPl = allInventoryAttrPl;
	}

	public AllInventory getAllInventory() {
		return this.allInventory;
	}

	public void setAllInventory(AllInventory allInventory) {
		this.allInventory = allInventory;
	}

}