package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the all_users database table.
 * 
 */
@Entity
@Table(name="all_users")
@NamedQuery(name="AllUser.findAll", query="SELECT a FROM AllUser a")
public class AllUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="active_status")
	private String activeStatus;

	private Timestamp created;

	@Column(name="created_by")
	private String createdBy;

	private String email;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	private String name;

	private String phone;

	//bi-directional many-to-one association to AllOrder
	@OneToMany(mappedBy="allUser")
	private List<AllOrder> allOrders;

	//bi-directional many-to-one association to AllUserAttribute
	@OneToMany(mappedBy="allUser")
	private List<AllUserAttribute> allUserAttributes;

	//bi-directional many-to-one association to AllUserSavedAddress
	@OneToMany(mappedBy="allUser")
	private List<AllUserSavedAddress> allUserSavedAddresses;

	public AllUser() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<AllOrder> getAllOrders() {
		return this.allOrders;
	}

	public void setAllOrders(List<AllOrder> allOrders) {
		this.allOrders = allOrders;
	}

	public AllOrder addAllOrder(AllOrder allOrder) {
		getAllOrders().add(allOrder);
		allOrder.setAllUser(this);

		return allOrder;
	}

	public AllOrder removeAllOrder(AllOrder allOrder) {
		getAllOrders().remove(allOrder);
		allOrder.setAllUser(null);

		return allOrder;
	}

	public List<AllUserAttribute> getAllUserAttributes() {
		return this.allUserAttributes;
	}

	public void setAllUserAttributes(List<AllUserAttribute> allUserAttributes) {
		this.allUserAttributes = allUserAttributes;
	}

	public AllUserAttribute addAllUserAttribute(AllUserAttribute allUserAttribute) {
		getAllUserAttributes().add(allUserAttribute);
		allUserAttribute.setAllUser(this);

		return allUserAttribute;
	}

	public AllUserAttribute removeAllUserAttribute(AllUserAttribute allUserAttribute) {
		getAllUserAttributes().remove(allUserAttribute);
		allUserAttribute.setAllUser(null);

		return allUserAttribute;
	}

	public List<AllUserSavedAddress> getAllUserSavedAddresses() {
		return this.allUserSavedAddresses;
	}

	public void setAllUserSavedAddresses(List<AllUserSavedAddress> allUserSavedAddresses) {
		this.allUserSavedAddresses = allUserSavedAddresses;
	}

	public AllUserSavedAddress addAllUserSavedAddress(AllUserSavedAddress allUserSavedAddress) {
		getAllUserSavedAddresses().add(allUserSavedAddress);
		allUserSavedAddress.setAllUser(this);

		return allUserSavedAddress;
	}

	public AllUserSavedAddress removeAllUserSavedAddress(AllUserSavedAddress allUserSavedAddress) {
		getAllUserSavedAddresses().remove(allUserSavedAddress);
		allUserSavedAddress.setAllUser(null);

		return allUserSavedAddress;
	}

}