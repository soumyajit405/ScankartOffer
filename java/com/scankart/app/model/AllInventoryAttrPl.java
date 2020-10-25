package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the all_Inventory_attr_pl database table.
 * 
 */
@Entity
@Table(name="all_inv_attr_pl")
@NamedQuery(name="AllInventoryAttrPl.findAll", query="SELECT a FROM AllInventoryAttrPl a")
public class AllInventoryAttrPl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp created;

	@Column(name="created_by")
	private String createdBy;

	private String description;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	private String name;

	//bi-directional many-to-one association to AllInventoryAttr
	@OneToMany(mappedBy="allInventoryAttrPl")
	private List<AllInventoryAttr> allInventoryAttrs;

	//bi-directional many-to-one association to BusinessInventoryAttribute
	@OneToMany(mappedBy="allInventoryAttrPl")
	private List<BusinessInventoryAttribute> businessInventoryAttributes;

	public AllInventoryAttrPl() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AllInventoryAttr> getAllInventoryAttrs() {
		return this.allInventoryAttrs;
	}

	public void setAllInventoryAttrs(List<AllInventoryAttr> allInventoryAttrs) {
		this.allInventoryAttrs = allInventoryAttrs;
	}

	public List<BusinessInventoryAttribute> getBusinessInventoryAttributes() {
	return this.businessInventoryAttributes;
	}

	public void setBusinessInventoryAttributes(List<BusinessInventoryAttribute> businessInventoryAttributes) {
		this.businessInventoryAttributes = businessInventoryAttributes;
	}

	
}