package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the all_instore_order_status database table.
 * 
 */
@Entity
@Table(name="all_instore_order_status")
@NamedQuery(name="AllInstoreOrderStatus.findAll", query="SELECT a FROM AllInstoreOrderStatus a")
public class AllInstoreOrderStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to AllOrder
	@ManyToOne
	@JoinColumn(name="all_instore_order_id")
	private AllOrder allOrder;

	//bi-directional many-to-one association to OrderStatusPl
	@ManyToOne
	@JoinColumn(name="instore_order_status_pl_id")
	private OrderStatusPl orderStatusPl;

	public AllInstoreOrderStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AllOrder getAllOrder() {
		return this.allOrder;
	}

	public void setAllOrder(AllOrder allOrder) {
		this.allOrder = allOrder;
	}

	public OrderStatusPl getOrderStatusPl() {
		return this.orderStatusPl;
	}

	public void setOrderStatusPl(OrderStatusPl orderStatusPl) {
		this.orderStatusPl = orderStatusPl;
	}

}