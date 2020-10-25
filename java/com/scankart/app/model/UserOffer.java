package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_offers database table.
 * 
 */
@Entity
@Table(name="user_offers")
@NamedQuery(name="UserOffer.findAll", query="SELECT u FROM UserOffer u")
public class UserOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="offer_date")
	private Timestamp offerDate;

	private String status;

	@JoinColumn(name="offer_id")
	//bi-directional many-to-one association to Offer
	@ManyToOne
	private Offer offer;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private AllUser allUser;

	public UserOffer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getOfferDate() {
		return this.offerDate;
	}

	public void setOfferDate(Timestamp offerDate) {
		this.offerDate = offerDate;
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

	public AllUser getAllUser() {
		return this.allUser;
	}

	public void setAllUser(AllUser allUser) {
		this.allUser = allUser;
	}

}