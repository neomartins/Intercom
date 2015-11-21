package com.dublinoffice;


/**
 * @author Neo
 *
 */
public class CustomerBean implements Comparable<CustomerBean>{
	
	/**
	 * 
	 */
	private Long customerId;
	/**
	 * 
	 */
	private String custumerName;
	/**
	 * 
	 */
	private Double latitude;
	/**
	 * 
	 */
	private Double longitude;	
	
	/**
	 * @param customerId
	 * @param custumerName
	 * @param latitude
	 * @param longitude
	 */
	public CustomerBean (Long customerId, String custumerName, String latitude, String longitude)
	{
		this.customerId = customerId;
		this.custumerName =  custumerName;
		this.latitude = Double.valueOf(latitude);
		this.longitude = Double.valueOf(longitude);
	}
	
	/**
	 * @return
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return custumerName
	 */
	public String getCustumerName() {
		return custumerName;
	}
	/**
	 * @param custumerName
	 */
	public void setCustumerName(String custumerName) {
		this.custumerName = custumerName;
	}
	/**
	 * @return latitude
	 */
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = Double.valueOf(latitude);
	}
	/**
	 * @return longitude
	 */
	public Double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = Double.valueOf(longitude);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(CustomerBean o) {
		return customerId.compareTo(o.getCustomerId());
	}
	
	
}
