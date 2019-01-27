package com.xyz.ekart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.ebean.Model;

@Entity
@Table(name="RETAILER")
public class Retailer extends Model{
	
	@Id
	@Column(name ="RETAILER_ID")
	private Long retailerId;
	
	@Column(name ="RETAILER_NAME")
	private String retailerName;
	
	@Column(name ="RETAILER_EMAIL_ID")
	private String retailerEmailId;

	@Column(name ="RETAILER_MOBILE_NUMBER")
	private String retailerMobileNumber;

	public Long getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(Long retailerId) {
		this.retailerId = retailerId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getRetailerEmailId() {
		return retailerEmailId;
	}

	public void setRetailerEmailId(String retailerEmailId) {
		this.retailerEmailId = retailerEmailId;
	}

	public String getRetailerMobileNumber() {
		return retailerMobileNumber;
	}

	public void setRetailerMobileNumber(String retailerMobileNumber) {
		this.retailerMobileNumber = retailerMobileNumber;
	}

	@Override
	public String toString() {
		return "Retailer [retailerId=" + retailerId + ", retailerName=" + retailerName + ", retailerEmailId="
				+ retailerEmailId + ", retailerMobileNumber=" + retailerMobileNumber + "]";
	}
}
