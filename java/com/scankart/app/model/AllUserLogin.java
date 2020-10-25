package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the all_user_login database table.
 * 
 */
@Entity
@Table(name="all_user_login")
@NamedQuery(name="AllUserLogin.findAll", query="SELECT a FROM AllUserLogin a")
public class AllUserLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="login_time")
	private Timestamp loginTime;

	@Column(name="logout_time")
	private Timestamp logoutTime;

	@Column(name="player_id")
	private String playerId;

	private String token;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to LoginType
	@ManyToOne
	@JoinColumn(name="type_id")
	private LoginType loginType;

	public AllUserLogin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Timestamp getLogoutTime() {
		return this.logoutTime;
	}

	public void setLogoutTime(Timestamp logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
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