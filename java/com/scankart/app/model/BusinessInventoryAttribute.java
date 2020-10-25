package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the business_inventory_attribute database table.
 * 
 */
@Entity
@Table(name="business_inventory_attribute")
@NamedQuery(name="BusinessInventoryAttribute.findAll", query="SELECT b FROM BusinessInventoryAttribute b")
public class BusinessInventoryAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to All_Inventory_attr_pl
	@ManyToOne
	@JoinColumn(name="all_inventory_attr_pl_id")
	private AllInventoryAttrPl allInventoryAttrPl;

	//bi-directional many-to-one association to BusinessTypePl
	@ManyToOne
	@JoinColumn(name="business_type_pl_id")
	private BusinessTypePl businessTypePl;

	public BusinessInventoryAttribute() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AllInventoryAttrPl getAllInventoryAttrPl() {
		return this.allInventoryAttrPl;
	}

	public void setAllInventoryAttrPl(AllInventoryAttrPl allInventoryAttrPl) {
		this.allInventoryAttrPl = allInventoryAttrPl;
	}

	public BusinessTypePl getBusinessTypePl() {
		return this.businessTypePl;
	}

	public void setBusinessTypePl(BusinessTypePl businessTypePl) {
		this.businessTypePl = businessTypePl;
	}

}