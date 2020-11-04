package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="property_table")
public class Property {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int propId;
	@Column
	private String configuration;	// Flat/Shop/Plot
	@Column
	private String offerType;	// Sell/Rent
	@Column
	private double offerCost;
	@Column
	private double areaSqft;
	@Column
	private String city;
	@Column
	private String address;
	@Column
	private String street;
	@Column
	private boolean status;	// Available(true)/ Sold(false)
	@ManyToOne
	@JoinColumn(name="broId")
	private Broker broker;
	@ManyToOne
	@JoinColumn(name="custId")
	private Customer customer;
	
	

	/**
	 * Default Constructor
	 */
	public Property() {
		super();
	}

	/**
	 * @param propId
	 * @param configuration
	 * @param offerType
	 * @param offerCost
	 * @param areaSqft
	 * @param city
	 * @param address
	 * @param street
	 * @param status
	 * @param broker
	 * @param customer
	 */
	public Property(int propId, String configuration, String offerType, double offerCost, double areaSqft, String city,
			String address, String street, boolean status, Broker broker, Customer customer) {
		super();
		this.propId = propId;
		this.configuration = configuration;
		this.offerType = offerType;
		this.offerCost = offerCost;
		this.areaSqft = areaSqft;
		this.city = city;
		this.address = address;
		this.street = street;
		this.status = status;
		this.broker = broker;
		this.customer=customer;
	}
	
	/**
	 * @return the propId
	 */
	public int getPropId() {
		return propId;
	}

	/**
	 * @param propId the propId to set
	 */
	public void setPropId(int propId) {
		this.propId = propId;
	}

	/**
	 * @return the configuration
	 */
	public String getConfiguration() {
		return configuration;
	}

	/**
	 * @param configuration the configuration to set
	 */
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}

	/**
	 * @return the offerType
	 */
	public String getOfferType() {
		return offerType;
	}

	/**
	 * @param offerType the offerType to set
	 */
	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	/**
	 * @return the offerCost
	 */
	public double getOfferCost() {
		return offerCost;
	}

	/**
	 * @param offerCost the offerCost to set
	 */
	public void setOfferCost(double offerCost) {
		this.offerCost = offerCost;
	}

	/**
	 * @return the areaSqft
	 */
	public double getAreaSqft() {
		return areaSqft;
	}

	/**
	 * @param areaSqft the areaSqft to set
	 */
	public void setAreaSqft(double areaSqft) {
		this.areaSqft = areaSqft;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the broker
	 */
	public Broker getBroker() {
		return broker;
	}

	/**
	 * @param broker the broker to set
	 */
	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Property [propId=" + propId + ", configuration=" + configuration + ", offerType=" + offerType
				+ ", offerCost=" + offerCost + ", areaSqft=" + areaSqft + ", city=" + city + ", address=" + address
				+ ", street=" + street + ", status=" + status + ", broker=" + broker + ", customer=" + customer + "]";
	}

	
	
	
	
}
