package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the offer_type_pl database table.
 * 
 */
@Entity
@Table(name="offer_type_pl")
@NamedQuery(name="OfferTypePl.findAll", query="SELECT o FROM OfferTypePl o")
public class OfferTypePl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp created;

	@Column(name="created_by")
	private String createdBy;

	private String descripton;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="offer_type")
	private String offerType;

	//bi-directional many-to-one association to Offer
	@OneToMany(mappedBy="offerTypePl")
	private List<Offer> offers;

	public OfferTypePl() {
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

	public String getDescripton() {
		return this.descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getOfferType() {
		return this.offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public List<Offer> getOffers() {
		return this.offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public Offer addOffer(Offer offer) {
		getOffers().add(offer);
		offer.setOfferTypePl(this);

		return offer;
	}

	public Offer removeOffer(Offer offer) {
		getOffers().remove(offer);
		offer.setOfferTypePl(null);

		return offer;
	}

}