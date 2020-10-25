package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the all_user_saved_address database table.
 * 
 */
@Entity
@Table(name="all_user_saved_address")
@NamedQuery(name="AllUserSavedAddress.findAll", query="SELECT a FROM AllUserSavedAddress a")
public class AllUserSavedAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="active_status")
	private String activeStatus;

	private Timestamp created;

	@Column(name="created_by")
	private String createdBy;

	private String description;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="all_users_id")
	private AllUser allUser;

	//bi-directional many-to-one association to SavedAddressTypePl
	@ManyToOne
	@JoinColumn(name="saved_address_type_pl_id")
	private SavedAddressTypePl savedAddressTypePl;

	public AllUserSavedAddress() {
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

	public AllUser getAllUser() {
		return this.allUser;
	}

	public void setAllUser(AllUser allUser) {
		this.allUser = allUser;
	}

	public SavedAddressTypePl getSavedAddressTypePl() {
		return this.savedAddressTypePl;
	}

	public void setSavedAddressTypePl(SavedAddressTypePl savedAddressTypePl) {
		this.savedAddressTypePl = savedAddressTypePl;
	}

}