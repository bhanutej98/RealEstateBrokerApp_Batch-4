package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



@Entity
@Table(name="user_table")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)	
@DiscriminatorColumn(
		name="Role_Type",
		discriminatorType=DiscriminatorType.STRING
)
public abstract class User {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private String mobile;
	@Column
	private String email;
	@Column
	private String city;
	
	/**
	 * 
	 */
	public User() {
		super();
	}
	//Parameterized constructors
	public User(int userid, String password, String role, String mobile, String email, String city) {
		super();
		this.userid = userid;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
	}
	//Getters and Setters
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
