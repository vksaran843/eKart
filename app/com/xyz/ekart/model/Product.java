package com.xyz.ekart.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.ebean.Model;

@Entity
@Table(name="PRODUCT")
public class Product extends Model{

	@Id
	@Column(name ="PRODUCT_ID")
	private Long productId;
	
	@Column(name ="PRODUCT_NAME")
	private String productName;

	@Column(name ="PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name ="PRODUCT_CATEGORY")
	private String productCategory;
	
	@Column(name ="TAX_PERCENTAGE")
	private String taxPercentage;
	
	@Column(name="PRODUCT_QUANTITY")
	private Long productQuantity;
	
	@Column(name="PRODUCT_PRICE")
	private String productPrice;
	
	@Column(name ="STATUS")
	private String status;
	
	@Column(name ="CREATED_DATE")
	private LocalDateTime createdDate;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(String taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productCategory=" + productCategory + ", taxPercentage=" + taxPercentage
				+ ", productQuantity=" + productQuantity + ", productPrice=" + productPrice + ", status=" + status
				+ ", createdDate=" + createdDate + "]";
	}
	
	

}
