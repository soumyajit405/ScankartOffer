package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user_attribute_type_pl database table.
 * 
 */
@Entity
@Table(name="user_attribute_type_pl")
@NamedQuery(name="UserAttributeTypePl.findAll", query="SELECT u FROM UserAttributeTypePl u")
public class UserAttributeTypePl implements Serializable {
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

	//bi-directional many-to-one association to AllUserAttribute
	@OneToMany(mappedBy="userAttributeTypePl")
	private List<AllUserAttribute> allUserAttributes;

	public UserAttributeTypePl() {
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

	public List<AllUserAttribute> getAllUserAttributes() {
		return this.allUserAttributes;
	}

	public void setAllUserAttributes(List<AllUserAttribute> allUserAttributes) {
		this.allUserAttributes = allUserAttributes;
	}

	public AllUserAttribute addAllUserAttribute(AllUserAttribute allUserAttribute) {
		getAllUserAttributes().add(allUserAttribute);
		allUserAttribute.setUserAttributeTypePl(this);

		return allUserAttribute;
	}

	public AllUserAttribute removeAllUserAttribute(AllUserAttribute allUserAttribute) {
		getAllUserAttributes().remove(allUserAttribute);
		allUserAttribute.setUserAttributeTypePl(null);

		return allUserAttribute;
	}

}