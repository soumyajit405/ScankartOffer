package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the business_type_pl database table.
 * 
 */
@Entity
@Table(name="business_type_pl")
@NamedQuery(name="BusinessTypePl.findAll", query="SELECT b FROM BusinessTypePl b")
public class BusinessTypePl implements Serializable {
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

	//bi-directional many-to-one association to AllInventory
	@OneToMany(mappedBy="businessTypePl")
	private List<AllInventory> allInventories;

	//bi-directional many-to-one association to AllMerchant
	@OneToMany(mappedBy="businessTypePl")
	private List<AllMerchant> allMerchants;

	//bi-directional many-to-one association to BusinessAttributeMapping
	@OneToMany(mappedBy="businessTypePl")
	private List<BusinessAttributeMapping> businessAttributeMappings;

	//bi-directional many-to-one association to BusinessInventoryAttribute
	@OneToMany(mappedBy="businessTypePl")
	private List<BusinessInventoryAttribute> businessInventoryAttributes;

	public BusinessTypePl() {
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

	public List<AllInventory> getAllInventories() {
		return this.allInventories;
	}

	public void setAllInventories(List<AllInventory> allInventories) {
		this.allInventories = allInventories;
	}

	public AllInventory addAllInventory(AllInventory allInventory) {
		getAllInventories().add(allInventory);
		allInventory.setBusinessTypePl(this);

		return allInventory;
	}

	public AllInventory removeAllInventory(AllInventory allInventory) {
		getAllInventories().remove(allInventory);
		allInventory.setBusinessTypePl(null);

		return allInventory;
	}

	public List<AllMerchant> getAllMerchants() {
		return this.allMerchants;
	}

	public void setAllMerchants(List<AllMerchant> allMerchants) {
		this.allMerchants = allMerchants;
	}

	public AllMerchant addAllMerchant(AllMerchant allMerchant) {
		getAllMerchants().add(allMerchant);
		allMerchant.setBusinessTypePl(this);

		return allMerchant;
	}

	public AllMerchant removeAllMerchant(AllMerchant allMerchant) {
		getAllMerchants().remove(allMerchant);
		allMerchant.setBusinessTypePl(null);

		return allMerchant;
	}

	public List<BusinessAttributeMapping> getBusinessAttributeMappings() {
		return this.businessAttributeMappings;
	}

	public void setBusinessAttributeMappings(List<BusinessAttributeMapping> businessAttributeMappings) {
		this.businessAttributeMappings = businessAttributeMappings;
	}

	public BusinessAttributeMapping addBusinessAttributeMapping(BusinessAttributeMapping businessAttributeMapping) {
		getBusinessAttributeMappings().add(businessAttributeMapping);
		businessAttributeMapping.setBusinessTypePl(this);

		return businessAttributeMapping;
	}

	public BusinessAttributeMapping removeBusinessAttributeMapping(BusinessAttributeMapping businessAttributeMapping) {
		getBusinessAttributeMappings().remove(businessAttributeMapping);
		businessAttributeMapping.setBusinessTypePl(null);

		return businessAttributeMapping;
	}

	public List<BusinessInventoryAttribute> getBusinessInventoryAttributes() {
		return this.businessInventoryAttributes;
	}

	public void setBusinessInventoryAttributes(List<BusinessInventoryAttribute> businessInventoryAttributes) {
		this.businessInventoryAttributes = businessInventoryAttributes;
	}

	public BusinessInventoryAttribute addBusinessInventoryAttribute(BusinessInventoryAttribute businessInventoryAttribute) {
		getBusinessInventoryAttributes().add(businessInventoryAttribute);
		businessInventoryAttribute.setBusinessTypePl(this);

		return businessInventoryAttribute;
	}

	public BusinessInventoryAttribute removeBusinessInventoryAttribute(BusinessInventoryAttribute businessInventoryAttribute) {
		getBusinessInventoryAttributes().remove(businessInventoryAttribute);
		businessInventoryAttribute.setBusinessTypePl(null);

		return businessInventoryAttribute;
	}

}