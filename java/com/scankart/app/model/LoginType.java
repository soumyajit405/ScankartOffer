package com.scankart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the login_type database table.
 * 
 */
@Entity
@Table(name="login_type")
@NamedQuery(name="LoginType.findAll", query="SELECT l FROM LoginType l")
public class LoginType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String type;

	//bi-directional many-to-one association to AllOtp
	@OneToMany(mappedBy="loginType")
	private List<AllOtp> allOtps;

	//bi-directional many-to-one association to AllUserLogin
	@OneToMany(mappedBy="loginType")
	private List<AllUserLogin> allUserLogins;

	public LoginType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<AllOtp> getAllOtps() {
		return this.allOtps;
	}

	public void setAllOtps(List<AllOtp> allOtps) {
		this.allOtps = allOtps;
	}

	public AllOtp addAllOtp(AllOtp allOtp) {
		getAllOtps().add(allOtp);
		allOtp.setLoginType(this);

		return allOtp;
	}

	public AllOtp removeAllOtp(AllOtp allOtp) {
		getAllOtps().remove(allOtp);
		allOtp.setLoginType(null);

		return allOtp;
	}

	public List<AllUserLogin> getAllUserLogins() {
		return this.allUserLogins;
	}

	public void setAllUserLogins(List<AllUserLogin> allUserLogins) {
		this.allUserLogins = allUserLogins;
	}

	public AllUserLogin addAllUserLogin(AllUserLogin allUserLogin) {
		getAllUserLogins().add(allUserLogin);
		allUserLogin.setLoginType(this);

		return allUserLogin;
	}

	public AllUserLogin removeAllUserLogin(AllUserLogin allUserLogin) {
		getAllUserLogins().remove(allUserLogin);
		allUserLogin.setLoginType(null);

		return allUserLogin;
	}

}