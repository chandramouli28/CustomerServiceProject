package com.utilityservicemanager.customerservice.registration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="username", nullable = true)
	private String username;
	
	@Column(name="password", nullable = true)
	private String password;
	
	@Column(name="email", nullable = true)
	private String email;
	
	@Column(name="phoneNum", nullable = true)
	private String phoneNum;	
	
	@Column(name="service_id", nullable = true)
	private String service_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	
	@Override
	public String toString(){
		return (this.username + " " + this.email + " " + this.phoneNum);
	}
	
}
