package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the business_attributes_type_pl database table.
 * 
 */
@Entity
@Table(name="business_attributes_type_pl")
@NamedQuery(name="BusinessAttributesTypePl.findAll", query="SELECT b FROM BusinessAttributesTypePl b")
public class BusinessAttributesTypePl implements Serializable {
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

	//bi-directional many-to-one association to BusinessAttributeMapping
	@OneToMany(mappedBy="businessAttributesTypePl")
	private List<BusinessAttributeMapping> businessAttributeMappings;

	public BusinessAttributesTypePl() {
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

	public List<BusinessAttributeMapping> getBusinessAttributeMappings() {
		return this.businessAttributeMappings;
	}

	public void setBusinessAttributeMappings(List<BusinessAttributeMapping> businessAttributeMappings) {
		this.businessAttributeMappings = businessAttributeMappings;
	}

	public BusinessAttributeMapping addBusinessAttributeMapping(BusinessAttributeMapping businessAttributeMapping) {
		getBusinessAttributeMappings().add(businessAttributeMapping);
		businessAttributeMapping.setBusinessAttributesTypePl(this);

		return businessAttributeMapping;
	}

	public BusinessAttributeMapping removeBusinessAttributeMapping(BusinessAttributeMapping businessAttributeMapping) {
		getBusinessAttributeMappings().remove(businessAttributeMapping);
		businessAttributeMapping.setBusinessAttributesTypePl(null);

		return businessAttributeMapping;
	}

}