package com.fynd.movie.management.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserMaster")
public class UserMaster implements Serializable {
	private static final long serialVersionUID = -1L;

	@Id
	@Column(name = "USER_ID")
	private BigDecimal USER_ID;

	@Column(name = "DISPLAY_USER_ID")
	private String DISPLAY_USER_ID;

	@Column(name = "PASSWORD")
	private String password;

	public BigDecimal getUSER_ID() {
		return this.USER_ID;
	}

	public void setUSER_ID(BigDecimal paramBigDecimal) {
		this.USER_ID = paramBigDecimal;
	}

	public String getDISPLAY_USER_ID() {
		return this.DISPLAY_USER_ID;
	}

	public void setDISPLAY_USER_ID(String paramString) {
		this.DISPLAY_USER_ID = paramString;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
