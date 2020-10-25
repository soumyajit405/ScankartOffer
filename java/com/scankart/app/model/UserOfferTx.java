package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_offer_tx database table.
 * 
 */
@Entity
@Table(name="user_offer_tx")
@NamedQuery(name="UserOfferTx.findAll", query="SELECT u FROM UserOfferTx u")
public class UserOfferTx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String status;

	@Column(name="tx_date")
	private Timestamp txDate;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private AllUser allUser;

	//bi-directional many-to-one association to Offer
	@ManyToOne
	private Offer offer;

	public UserOfferTx() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getTxDate() {
		return this.txDate;
	}

	public void setTxDate(Timestamp txDate) {
		this.txDate = txDate;
	}

	public AllUser getAllUser() {
		return this.allUser;
	}

	public void setAllUser(AllUser allUser) {
		this.allUser = allUser;
	}

	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}