package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the merchant_offers database table.
 * 
 */
@Entity
@Table(name="merchant_offers")
@NamedQuery(name="MerchantOffer.findAll", query="SELECT m FROM MerchantOffer m")
public class MerchantOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	
	@JoinColumn(name="merchant_id")
	@ManyToOne
	private AllMerchant allMerchant;

	private String status;

	@JoinColumn(name="offer_id")
	//bi-directional many-to-one association to Offer
	@ManyToOne
	private Offer offer;

	public MerchantOffer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AllMerchant getAllMerchant() {
		return allMerchant;
	}

	public void setAllMerchant(AllMerchant allMerchant) {
		this.allMerchant = allMerchant;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}