package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the all_user_attributes database table.
 * 
 */
@Entity
@Table(name="all_user_attributes")
@NamedQuery(name="AllUserAttribute.findAll", query="SELECT a FROM AllUserAttribute a")
public class AllUserAttribute implements Serializable {
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

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="all_user_id")
	private AllUser allUser;

	//bi-directional many-to-one association to UserAttributeTypePl
	@ManyToOne
	@JoinColumn(name="user_attr_type_pl_id")
	private UserAttributeTypePl userAttributeTypePl;

	public AllUserAttribute() {
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

	public AllUser getAllUser() {
		return this.allUser;
	}

	public void setAllUser(AllUser allUser) {
		this.allUser = allUser;
	}

	public UserAttributeTypePl getUserAttributeTypePl() {
		return this.userAttributeTypePl;
	}

	public void setUserAttributeTypePl(UserAttributeTypePl userAttributeTypePl) {
		this.userAttributeTypePl = userAttributeTypePl;
	}

}