package com.cg.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("Customer")
public class Customer extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4216677041291350122L;
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custId;
	@Column
	private String custName;
	@OneToMany(mappedBy="customer")
	private List<Property> properties;
	
	
	/**
	 * 
	 */
	public Customer() {
	}
	/**
	 * @param userid
	 * @param password
	 * @param role
	 * @param mobile
	 * @param email
	 * @param city
	 * @param custId
	 * @param custName
	 * @param properties
	 */
	public Customer(int userid, String password, String role, String mobile, String email, String city, int custId,
			String custName, List<Property> properties) {
		super(userid, password, role, mobile, email, city);
		this.custId = custId;
		this.custName = custName;
		this.properties = properties;
	}
	//getters and setters
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	//condition for custname to be more than 3 letters
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", properties=" + properties + "]";
	}
	
		
	
}
