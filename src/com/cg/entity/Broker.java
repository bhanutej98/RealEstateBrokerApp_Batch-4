package com.cg.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;




@Entity
@DiscriminatorValue("Broker")
public class Broker extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6395571388118189879L;
	/**
	 * The Broker Class contains all the Entities, Variables, Constructors and
	 * all the necessary  Class methods.*/

	@Column
	private int broId;
	@Column(unique=true)
	private String broName;
	@OneToMany(mappedBy="broker")
	private List<Property> properties;
	/**
	 * 
	 */
	public Broker() {
		super();
	}
	/**
	 * @param userid
	 * @param password
	 * @param role
	 * @param mobile
	 * @param email
	 * @param city
	 * @param broId
	 * @param broName
	 * @param properties
	 */
	public Broker(int userid, String password, String role, String mobile, String email, String city, int broId,
			String broName, List<Property> properties) {
		super(userid, password, role, mobile, email, city);
		this.broId = broId;
		this.broName = broName;
		this.properties = properties;
	}
	/**
	 * @return the broId
	 */
	public int getBroId() {
		return broId;
	}
	/**
	 * @param broId the broId to set
	 */
	public void setBroId(int broId) {
		this.broId = broId;
	}
	/**
	 * @return the broName
	 */
	public String getBroName() {
		return broName;
	}
	/**
	 * @param broName the broName to set
	 */
	public void setBroName(String broName) {
		this.broName = broName;
	}
	/**
	 * @return the properties
	 */
	public List<Property> getProperties() {
		return properties;
	}
	/**
	 * @param properties the properties to set
	 */
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}	
	
	@Override
	public String toString() {
		return "Broker [broId=" + broId + ", broName=" + broName + ", properties=" + properties + "]";
	}
	
	
}	
		