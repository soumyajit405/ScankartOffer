package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the all_otp database table.
 * 
 */
@Entity
@Table(name="all_otp")
@NamedQuery(name="AllOtp.findAll", query="SELECT a FROM AllOtp a")
public class AllOtp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp created;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	private String otp;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to LoginType
	@ManyToOne
	@JoinColumn(name="type_id")
	private LoginType loginType;

	public AllOtp() {
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

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LoginType getLoginType() {
		return this.loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

}