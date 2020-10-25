package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the all_merchant database table.
 * 
 */
@Entity
@Table(name="all_merchant")
@NamedQuery(name="AllMerchant.findAll", query="SELECT a FROM AllMerchant a")
public class AllMerchant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="active_status")
	private String activeStatus;
	@Column(name="validated_status")
	private String validatedStatus;

	
	public String getValidatedStatus() {
		return validatedStatus;
	}

	public void setValidatedStatus(String validatedStatus) {
		this.validatedStatus = validatedStatus;
	}

	@Column(name="login_id")
	private String loginId;

	@Column(name="code")
	private String code;

	@Column(name="current_active_sessions")
	private String currentActiveSessions;

	@Column(name="max_active_sessions_allowed")
	private String maxActiveSessionsAllowed;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCurrentActiveSessions() {
		return currentActiveSessions;
	}

	public void setCurrentActiveSessions(String currentActiveSessions) {
		this.currentActiveSessions = currentActiveSessions;
	}

	public String getMaxActiveSessionsAllowed() {
		return maxActiveSessionsAllowed;
	}

	public void setMaxActiveSessionsAllowed(String maxActiveSessionsAllowed) {
		this.maxActiveSessionsAllowed = maxActiveSessionsAllowed;
	}

	private String name;

	private String phone;

	//bi-directional many-to-one association to AllInventory
	@OneToMany(mappedBy="allMerchant")
	private List<AllInventory> allInventories;


	//bi-directional many-to-one association to AllMerchantAttribute
	@OneToMany(mappedBy="allMerchant")
	private List<AllMerchantAttribute> allMerchantAttributes;

	//bi-directional many-to-one association to AllOrder
	@OneToMany(mappedBy="allMerchant")
	private List<AllOrder> allOrders;

	public AllMerchant() {
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

	public List<AllInventory> getAllInventories() {
		return this.allInventories;
	}

	public void setAllInventories(List<AllInventory> allInventories) {
		this.allInventories = allInventories;
	}

	public AllInventory addAllInventory(AllInventory allInventory) {
		getAllInventories().add(allInventory);
		allInventory.setAllMerchant(this);

		return allInventory;
	}

	public AllInventory removeAllInventory(AllInventory allInventory) {
		getAllInventories().remove(allInventory);
		allInventory.setAllMerchant(null);

		return allInventory;
	}

	public List<AllMerchantAttribute> getAllMerchantAttributes() {
		return this.allMerchantAttributes;
	}

	public void setAllMerchantAttributes(List<AllMerchantAttribute> allMerchantAttributes) {
		this.allMerchantAttributes = allMerchantAttributes;
	}

	public AllMerchantAttribute addAllMerchantAttribute(AllMerchantAttribute allMerchantAttribute) {
		getAllMerchantAttributes().add(allMerchantAttribute);
		allMerchantAttribute.setAllMerchant(this);

		return allMerchantAttribute;
	}

	public AllMerchantAttribute removeAllMerchantAttribute(AllMerchantAttribute allMerchantAttribute) {
		getAllMerchantAttributes().remove(allMerchantAttribute);
		allMerchantAttribute.setAllMerchant(null);

		return allMerchantAttribute;
	}

	public List<AllOrder> getAllOrders() {
		return this.allOrders;
	}

	public void setAllOrders(List<AllOrder> allOrders) {
		this.allOrders = allOrders;
	}

	public AllOrder addAllOrder(AllOrder allOrder) {
		getAllOrders().add(allOrder);
		allOrder.setAllMerchant(this);

		return allOrder;
	}

	public AllOrder removeAllOrder(AllOrder allOrder) {
		getAllOrders().remove(allOrder);
		allOrder.setAllMerchant(null);

		return allOrder;
	}

}