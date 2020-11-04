package com.cg.pojo;

public class PropertyCriteria {
	private String config;		// Flat/Shop/Plot
	private String offer;		// Sale/Rent
	private String city;		// Not specified then all
	private double minCost;		// Not specified then 0
	private double maxCost;		// Not specified then max double value
	/**
	 * 
	 */
	public PropertyCriteria() {
		super();
	}
	/**
	 * @param config
	 * @param offer
	 * @param city
	 * @param minCost
	 * @param maxCost
	 */
	public PropertyCriteria(String config, String offer, String city, double minCost, double maxCost) {
		super();
		this.config = config;
		this.offer = offer;
		this.city = city;
		this.minCost = minCost;
		this.maxCost = maxCost;
	}
	/**
	 * @return the config
	 */
	public String getConfig() {
		return config;
	}
	/**
	 * @param config the config to set
	 */
	public void setConfig(String config) {
		this.config = config;
	}
	/**
	 * @return the offer
	 */
	public String getOffer() {
		return offer;
	}
	/**
	 * @param offer the offer to set
	 */
	public void setOffer(String offer) {
		this.offer = offer;
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
	 * @return the minCost
	 */
	public double getMinCost() {
		return minCost;
	}
	/**
	 * @param minCost the minCost to set
	 */
	public void setMinCost(double minCost) {
		this.minCost = minCost;
	}
	/**
	 * @return the maxCost
	 */
	public double getMaxCost() {
		return maxCost;
	}
	/**
	 * @param maxCost the maxCost to set
	 */
	public void setMaxCost(double maxCost) {
		this.maxCost = maxCost;
	}
	
	
}
