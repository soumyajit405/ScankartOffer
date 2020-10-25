package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the all_inventory database table.
 * 
 */
@Entity
@Table(name="all_inventory")
@NamedQuery(name="AllInventory.findAll", query="SELECT a FROM AllInventory a")
public class AllInventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private int id;

	@Column(name="available_quantity")
	private int availableQuantity;

	private String name;

	private String status;

	//bi-directional many-to-one association to AllMerchant
	@ManyToOne
	@JoinColumn(name="all_merchant_id")
	private AllMerchant allMerchant;

	//bi-directional many-to-one association to BusinessTypePl
	@ManyToOne
	@JoinColumn(name="business_type_pl_id")
	private BusinessTypePl businessTypePl;

	//bi-directional many-to-one association to AllInventoryAttr
	@OneToMany(mappedBy="allInventory")
	private List<AllInventoryAttr> allInventoryAttrs;

	//bi-directional many-to-one association to AllInventoryTx
	@OneToMany(mappedBy="allInventory")
	private List<AllInventoryTx> allInventoryTxs;

	public AllInventory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAvailableQuantity() {
		return this.availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AllMerchant getAllMerchant() {
		return this.allMerchant;
	}

	public void setAllMerchant(AllMerchant allMerchant) {
		this.allMerchant = allMerchant;
	}

	public BusinessTypePl getBusinessTypePl() {
		return this.businessTypePl;
	}

	public void setBusinessTypePl(BusinessTypePl businessTypePl) {
		this.businessTypePl = businessTypePl;
	}

	public List<AllInventoryAttr> getAllInventoryAttrs() {
		return this.allInventoryAttrs;
	}

	public void setAllInventoryAttrs(List<AllInventoryAttr> allInventoryAttrs) {
		this.allInventoryAttrs = allInventoryAttrs;
	}

	public AllInventoryAttr addAllInventoryAttr(AllInventoryAttr allInventoryAttr) {
		getAllInventoryAttrs().add(allInventoryAttr);
		allInventoryAttr.setAllInventory(this);

		return allInventoryAttr;
	}

	public AllInventoryAttr removeAllInventoryAttr(AllInventoryAttr allInventoryAttr) {
		getAllInventoryAttrs().remove(allInventoryAttr);
		allInventoryAttr.setAllInventory(null);

		return allInventoryAttr;
	}

	public List<AllInventoryTx> getAllInventoryTxs() {
		return this.allInventoryTxs;
	}

	public void setAllInventoryTxs(List<AllInventoryTx> allInventoryTxs) {
		this.allInventoryTxs = allInventoryTxs;
	}

	public AllInventoryTx addAllInventoryTx(AllInventoryTx allInventoryTx) {
		getAllInventoryTxs().add(allInventoryTx);
		allInventoryTx.setAllInventory(this);

		return allInventoryTx;
	}

	public AllInventoryTx removeAllInventoryTx(AllInventoryTx allInventoryTx) {
		getAllInventoryTxs().remove(allInventoryTx);
		allInventoryTx.setAllInventory(null);

		return allInventoryTx;
	}

}