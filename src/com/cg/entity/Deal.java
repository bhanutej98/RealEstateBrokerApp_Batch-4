package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
@Table(name = "deal_table")
public class Deal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int dealId;
	@Column
	private LocalDate dealDate;
	@Column
	private double dealCost;
	@OneToOne/*(cascade=CascadeType.ALL)*/
	@JoinColumn(name="custId")
	private Customer customer;
	@OneToOne/*(cascade=CascadeType.ALL)*/
	@JoinColumn(name="propId")
	private Property property;
	
	public Deal() {
	}
	
	
	public Deal(int dealId, LocalDate dealDate, double dealCost, Customer customer, Property property) {
		super();
		this.dealId = dealId;
		this.dealDate = dealDate;
		this.dealCost = dealCost;
		this.customer = customer;
		this.property = property;
	}
	
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public LocalDate getDealDate() {
		return dealDate;
	}
	public void setDealDate(LocalDate dealDate) {
		this.dealDate = dealDate;
	}
	public double getDealCost() {
		return dealCost;
	}
	public void setDealCost(double dealCost) {
		this.dealCost = dealCost;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}


	@Override
	public String toString() {
		return "Deal [dealId=" + dealId + ", dealDate=" + dealDate + ", dealCost=" + dealCost + ", property=" + property
				+ "]";
	}


	
	
}
