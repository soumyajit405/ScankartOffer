package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the all_instore_order_items database table.
 * 
 */
@Entity
@Table(name="all_instore_order_items")
@NamedQuery(name="AllInstoreOrderItem.findAll", query="SELECT a FROM AllInstoreOrderItem a")
public class AllInstoreOrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="added_by")
	private String addedBy;

	@Column(name="merchant_inv_id")
	private String merchantInvId;

	private int quantity;

	@Column(name="total_price")
	private float totalPrice;
	
	//bi-directional many-to-one association to AllOrder
		@ManyToOne
		@JoinColumn(name="order_id")
		private AllOrder allOrder;

	public AllOrder getAllOrder() {
			return allOrder;
		}

		public void setAllOrder(AllOrder allOrder) {
			this.allOrder = allOrder;
		}

	public AllInstoreOrderItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddedBy() {
		return this.addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getMerchantInvId() {
		return this.merchantInvId;
	}

	public void setMerchantInvId(String merchantInvId) {
		this.merchantInvId = merchantInvId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}