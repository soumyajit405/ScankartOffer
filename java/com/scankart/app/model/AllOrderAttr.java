package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the all_order_attr database table.
 * 
 */
@Entity
@Table(name="all_order_attr")
@NamedQuery(name="AllOrderAttr.findAll", query="SELECT a FROM AllOrderAttr a")
public class AllOrderAttr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String value;

	//bi-directional many-to-one association to AllOrder
	@ManyToOne
	@JoinColumn(name="all_order_id")
	private AllOrder allOrder;

	//bi-directional many-to-one association to OrderAttributeTypePl
	@ManyToOne
	@JoinColumn(name="instore_order_attribute_type_pl_id")
	private OrderAttributeTypePl orderAttributeTypePl;

	public AllOrderAttr() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public AllOrder getAllOrder() {
		return this.allOrder;
	}

	public void setAllOrder(AllOrder allOrder) {
		this.allOrder = allOrder;
	}

	public OrderAttributeTypePl getOrderAttributeTypePl() {
		return this.orderAttributeTypePl;
	}

	public void setOrderAttributeTypePl(OrderAttributeTypePl orderAttributeTypePl) {
		this.orderAttributeTypePl = orderAttributeTypePl;
	}

}