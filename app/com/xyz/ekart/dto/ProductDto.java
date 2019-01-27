package com.xyz.ekart.dto;

public class ProductDto {

	private Long productId;
	
	private Long productQuantity;
	
	private String totalPrice;
		
	private String status;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productQuantity=" + productQuantity + ", totalPrice="
				+ totalPrice + ", status=" + status + "]";
	}
	
}
