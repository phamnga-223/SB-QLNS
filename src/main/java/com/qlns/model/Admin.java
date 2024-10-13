package com.qlns.model;

import com.qlns.config.PasswordMatches;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
@PasswordMatches
public class Admin {

	@Id
	@Column
	private int id;
	@Column
	@NotBlank(message = "Username is mandatory")
	private String username;
	@Column
	@NotBlank(message = "Password is mandatory")
	private String password;
	private String matchingPassword;
	@Column
	private String fullName;
	@Column
	private String phone;
	
	public Admin() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

}
