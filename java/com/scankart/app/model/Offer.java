package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the offers database table.
 * 
 */
@Entity
@Table(name="offers")
@NamedQuery(name="Offer.findAll", query="SELECT o FROM Offer o")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cashback;

	@Column(name="discount_percent")
	private int discountPercent;

	@Column(name="end_date")
	private Timestamp endDate;

	@Column(name="max_discount")
	private int maxDiscount;

	@Column(name="max_members")
	private int maxMember;

	@Column(name="max_times")
	private int maxTimes;

	@Column(name="offer_name")
	private String offerName;

	@Column(name="offer_owner")
	private String offerOwner;

	@Column(name="start_date")
	private Timestamp startDate;

	private String status;

	//bi-directional many-to-one association to MerchantOffer
	@OneToMany(mappedBy="offer")
	private List<MerchantOffer> merchantOffers;

	//bi-directional many-to-one association to OfferTypePl
	@ManyToOne
	@JoinColumn(name="offer_type_id")
	private OfferTypePl offerTypePl;

	//bi-directional many-to-one association to BusinessTypePl
	@ManyToOne
	@JoinColumn(name="business_type_id")
	private BusinessTypePl businessTypePl;

	//bi-directional many-to-one association to UserOfferTx
	@OneToMany(mappedBy="offer")
	private List<UserOfferTx> userOfferTxs;

	//bi-directional many-to-one association to UserOffer
	@OneToMany(mappedBy="offer")
	private List<UserOffer> userOffers;

	public Offer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCashback() {
		return this.cashback;
	}

	public void setCashback(int cashback) {
		this.cashback = cashback;
	}

	public int getDiscountPercent() {
		return this.discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public int getMaxDiscount() {
		return this.maxDiscount;
	}

	public void setMaxDiscount(int maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	public int getMaxMember() {
		return this.maxMember;
	}

	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}

	public int getMaxTimes() {
		return this.maxTimes;
	}

	public void setMaxTimes(int maxTimes) {
		this.maxTimes = maxTimes;
	}

	public String getOfferName() {
		return this.offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferOwner() {
		return this.offerOwner;
	}

	public void setOfferOwner(String offerOwner) {
		this.offerOwner = offerOwner;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<MerchantOffer> getMerchantOffers() {
		return this.merchantOffers;
	}

	public void setMerchantOffers(List<MerchantOffer> merchantOffers) {
		this.merchantOffers = merchantOffers;
	}

	public MerchantOffer addMerchantOffer(MerchantOffer merchantOffer) {
		getMerchantOffers().add(merchantOffer);
		merchantOffer.setOffer(this);

		return merchantOffer;
	}

	public MerchantOffer removeMerchantOffer(MerchantOffer merchantOffer) {
		getMerchantOffers().remove(merchantOffer);
		merchantOffer.setOffer(null);

		return merchantOffer;
	}

	public OfferTypePl getOfferTypePl() {
		return this.offerTypePl;
	}

	public void setOfferTypePl(OfferTypePl offerTypePl) {
		this.offerTypePl = offerTypePl;
	}

	public BusinessTypePl getBusinessTypePl() {
		return this.businessTypePl;
	}

	public void setBusinessTypePl(BusinessTypePl businessTypePl) {
		this.businessTypePl = businessTypePl;
	}

	public List<UserOfferTx> getUserOfferTxs() {
		return this.userOfferTxs;
	}

	public void setUserOfferTxs(List<UserOfferTx> userOfferTxs) {
		this.userOfferTxs = userOfferTxs;
	}

	public UserOfferTx addUserOfferTx(UserOfferTx userOfferTx) {
		getUserOfferTxs().add(userOfferTx);
		userOfferTx.setOffer(this);

		return userOfferTx;
	}

	public UserOfferTx removeUserOfferTx(UserOfferTx userOfferTx) {
		getUserOfferTxs().remove(userOfferTx);
		userOfferTx.setOffer(null);

		return userOfferTx;
	}

	public List<UserOffer> getUserOffers() {
		return this.userOffers;
	}

	public void setUserOffers(List<UserOffer> userOffers) {
		this.userOffers = userOffers;
	}

	public UserOffer addUserOffer(UserOffer userOffer) {
		getUserOffers().add(userOffer);
		userOffer.setOffer(this);

		return userOffer;
	}

	public UserOffer removeUserOffer(UserOffer userOffer) {
		getUserOffers().remove(userOffer);
		userOffer.setOffer(null);

		return userOffer;
	}

}