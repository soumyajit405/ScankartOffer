package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the all_orders database table.
 * 
 */
@Entity
@Table(name="all_orders")
@NamedQuery(name="AllOrder.findAll", query="SELECT a FROM AllOrder a")
public class AllOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp created;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="purchase_date")
	private Timestamp purchaseDate;

	//bi-directional many-to-one association to AllInstoreOrderStatus
	@OneToMany(mappedBy="allOrder")
	private List<AllInstoreOrderStatus> allInstoreOrderStatuses;

	//bi-directional many-to-one association to AllOrderAttr
	@OneToMany(mappedBy="allOrder")
	private List<AllOrderAttr> allOrderAttrs;
	
	//bi-directional many-to-one association to AllOrderAttr
		@OneToMany(mappedBy="allOrder")
		private List<AllInstoreOrderItem> allOrderItems;

	public List<AllInstoreOrderItem> getAllOrderItems() {
			return allOrderItems;
		}

		public void setAllOrderItems(List<AllInstoreOrderItem> allOrderItems) {
			this.allOrderItems = allOrderItems;
		}

	//bi-directional many-to-one association to AllMerchant
	@ManyToOne
	@JoinColumn(name="all_merchant_id")
	private AllMerchant allMerchant;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="all_users_id")
	private AllUser allUser;

	//bi-directional many-to-one association to BusinessAttributeMapping
	@ManyToOne
	@JoinColumn(name="business_type")
	private BusinessTypePl businessType;
	
	@ManyToOne
	@JoinColumn(name="order_type")
	private OrderTypePl orderType;

	public AllOrder() {
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

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Timestamp getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public List<AllInstoreOrderStatus> getAllInstoreOrderStatuses() {
		return this.allInstoreOrderStatuses;
	}

	public void setAllInstoreOrderStatuses(List<AllInstoreOrderStatus> allInstoreOrderStatuses) {
		this.allInstoreOrderStatuses = allInstoreOrderStatuses;
	}

	public AllInstoreOrderStatus addAllInstoreOrderStatus(AllInstoreOrderStatus allInstoreOrderStatus) {
		getAllInstoreOrderStatuses().add(allInstoreOrderStatus);
		allInstoreOrderStatus.setAllOrder(this);

		return allInstoreOrderStatus;
	}

	public AllInstoreOrderStatus removeAllInstoreOrderStatus(AllInstoreOrderStatus allInstoreOrderStatus) {
		getAllInstoreOrderStatuses().remove(allInstoreOrderStatus);
		allInstoreOrderStatus.setAllOrder(null);

		return allInstoreOrderStatus;
	}

	public List<AllOrderAttr> getAllOrderAttrs() {
		return this.allOrderAttrs;
	}

	public void setAllOrderAttrs(List<AllOrderAttr> allOrderAttrs) {
		this.allOrderAttrs = allOrderAttrs;
	}

	public AllOrderAttr addAllOrderAttr(AllOrderAttr allOrderAttr) {
		getAllOrderAttrs().add(allOrderAttr);
		allOrderAttr.setAllOrder(this);

		return allOrderAttr;
	}

	public AllOrderAttr removeAllOrderAttr(AllOrderAttr allOrderAttr) {
		getAllOrderAttrs().remove(allOrderAttr);
		allOrderAttr.setAllOrder(null);

		return allOrderAttr;
	}

	public AllMerchant getAllMerchant() {
		return this.allMerchant;
	}

	public void setAllMerchant(AllMerchant allMerchant) {
		this.allMerchant = allMerchant;
	}

	public AllUser getAllUser() {
		return this.allUser;
	}

	public void setAllUser(AllUser allUser) {
		this.allUser = allUser;
	}

	public BusinessTypePl getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessTypePl businessType) {
		this.businessType = businessType;
	}

	public OrderTypePl getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderTypePl orderType) {
		this.orderType = orderType;
	}

}