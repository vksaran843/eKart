package com.xyz.ekart.dto;

import java.util.List;

public class PlaceOrderRequestDto {

	private Long customerId;
	
	private String orderAmount;
	
	private String paymentMode;
	
	private String paymentStatus;
	
	private List<ProductDto> productList;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public List<ProductDto> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "PlaceOrderRequestDto [customerId=" + customerId + ", orderAmount=" + orderAmount + ", paymentMode="
				+ paymentMode + ", paymentStatus=" + paymentStatus + ", productList=" + productList + "]";
	}
	
	
}
