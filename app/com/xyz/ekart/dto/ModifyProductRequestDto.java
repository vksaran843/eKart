package com.xyz.ekart.dto;

public class ModifyProductRequestDto {

	private Long productId;
	
	private String productName;

	private String productDescription;

	private String productCategory;
	
	private String taxPercentage;
	
	private Long productQuantity;
	
	private String productPrice;

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

	@Override
	public String toString() {
		return "ModifyProductRequestDto [productId=" + productId + ", productName=" + productName
				+ ", productDescription=" + productDescription + ", productCategory=" + productCategory
				+ ", taxPercentage=" + taxPercentage + ", productQuantity=" + productQuantity + ", productPrice="
				+ productPrice + "]";
	}
}
