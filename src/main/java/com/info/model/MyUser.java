package com.info.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="USER_MASTER")
public class MyUser {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	
	@Column(name="USER_NAME")
//	@NotNull
//	@NotEmpty
	private String userName;
	
	@Column(name="EMAIL")
	@NotNull
	@NotEmpty
	private String email;
	
	@Column(name="PASSWORD")
	@NotNull
	@NotEmpty
	private String password;
	
	@Column(name="MOBILE")
//	@NotNull(message = "{myUser.confirmPassword.invalid}")
	private String mobile;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	
}
