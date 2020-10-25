package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the order_attribute_type_pl database table.
 * 
 */
@Entity
@Table(name="order_attribute_type_pl")
@NamedQuery(name="OrderAttributeTypePl.findAll", query="SELECT o FROM OrderAttributeTypePl o")
public class OrderAttributeTypePl implements Serializable {
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

	private String name;

	//bi-directional many-to-one association to AllOrderAttr
	@OneToMany(mappedBy="orderAttributeTypePl")
	private List<AllOrderAttr> allOrderAttrs;

	public OrderAttributeTypePl() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AllOrderAttr> getAllOrderAttrs() {
		return this.allOrderAttrs;
	}

	public void setAllOrderAttrs(List<AllOrderAttr> allOrderAttrs) {
		this.allOrderAttrs = allOrderAttrs;
	}

	public AllOrderAttr addAllOrderAttr(AllOrderAttr allOrderAttr) {
		getAllOrderAttrs().add(allOrderAttr);
		allOrderAttr.setOrderAttributeTypePl(this);

		return allOrderAttr;
	}

	public AllOrderAttr removeAllOrderAttr(AllOrderAttr allOrderAttr) {
		getAllOrderAttrs().remove(allOrderAttr);
		allOrderAttr.setOrderAttributeTypePl(null);

		return allOrderAttr;
	}

}