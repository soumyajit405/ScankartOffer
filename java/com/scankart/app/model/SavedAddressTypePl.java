package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the saved_address_type_pl database table.
 * 
 */
@Entity
@Table(name="saved_address_type_pl")
@NamedQuery(name="SavedAddressTypePl.findAll", query="SELECT s FROM SavedAddressTypePl s")
public class SavedAddressTypePl implements Serializable {
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

	//bi-directional many-to-one association to AllUserSavedAddress
	@OneToMany(mappedBy="savedAddressTypePl")
	private List<AllUserSavedAddress> allUserSavedAddresses;

	public SavedAddressTypePl() {
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

	public List<AllUserSavedAddress> getAllUserSavedAddresses() {
		return this.allUserSavedAddresses;
	}

	public void setAllUserSavedAddresses(List<AllUserSavedAddress> allUserSavedAddresses) {
		this.allUserSavedAddresses = allUserSavedAddresses;
	}

	public AllUserSavedAddress addAllUserSavedAddress(AllUserSavedAddress allUserSavedAddress) {
		getAllUserSavedAddresses().add(allUserSavedAddress);
		allUserSavedAddress.setSavedAddressTypePl(this);

		return allUserSavedAddress;
	}

	public AllUserSavedAddress removeAllUserSavedAddress(AllUserSavedAddress allUserSavedAddress) {
		getAllUserSavedAddresses().remove(allUserSavedAddress);
		allUserSavedAddress.setSavedAddressTypePl(null);

		return allUserSavedAddress;
	}

}