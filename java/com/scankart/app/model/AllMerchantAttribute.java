package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the all_merchant_attributes database table.
 * 
 */
@Entity
@Table(name="all_merchant_attributes")
@NamedQuery(name="AllMerchantAttribute.findAll", query="SELECT a FROM AllMerchantAttribute a")
public class AllMerchantAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="active_status")
	private String activeStatus;

	private Timestamp created;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	private String value;

	//bi-directional many-to-one association to AllMerchant
	@ManyToOne
	@JoinColumn(name="all_merchant_id")
	private AllMerchant allMerchant;

	//bi-directional many-to-one association to BusinessAttributeMapping
	@ManyToOne
	@JoinColumn(name="business_attr_type_id")
	private BusinessAttributesTypePl businessAttrTypePl;

	public AllMerchantAttribute() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public AllMerchant getAllMerchant() {
		return this.allMerchant;
	}

	public void setAllMerchant(AllMerchant allMerchant) {
		this.allMerchant = allMerchant;
	}

	public BusinessAttributesTypePl getBusinessAttrTypePl() {
		return businessAttrTypePl;
	}

	public void setBusinessAttrTypePl(BusinessAttributesTypePl businessAttrTypePl) {
		this.businessAttrTypePl = businessAttrTypePl;
	}



}