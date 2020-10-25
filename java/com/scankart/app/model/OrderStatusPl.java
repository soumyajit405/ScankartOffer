package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the order_status_pl database table.
 * 
 */
@Entity
@Table(name="order_status_pl")
@NamedQuery(name="OrderStatusPl.findAll", query="SELECT o FROM OrderStatusPl o")
public class OrderStatusPl implements Serializable {
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

	//bi-directional many-to-one association to AllInstoreOrderStatus
	@OneToMany(mappedBy="orderStatusPl")
	private List<AllInstoreOrderStatus> allInstoreOrderStatuses;

	public OrderStatusPl() {
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

	public List<AllInstoreOrderStatus> getAllInstoreOrderStatuses() {
		return this.allInstoreOrderStatuses;
	}

	public void setAllInstoreOrderStatuses(List<AllInstoreOrderStatus> allInstoreOrderStatuses) {
		this.allInstoreOrderStatuses = allInstoreOrderStatuses;
	}

	public AllInstoreOrderStatus addAllInstoreOrderStatus(AllInstoreOrderStatus allInstoreOrderStatus) {
		getAllInstoreOrderStatuses().add(allInstoreOrderStatus);
		allInstoreOrderStatus.setOrderStatusPl(this);

		return allInstoreOrderStatus;
	}

	public AllInstoreOrderStatus removeAllInstoreOrderStatus(AllInstoreOrderStatus allInstoreOrderStatus) {
		getAllInstoreOrderStatuses().remove(allInstoreOrderStatus);
		allInstoreOrderStatus.setOrderStatusPl(null);

		return allInstoreOrderStatus;
	}

}