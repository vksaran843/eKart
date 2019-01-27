package com.xyz.ekart.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {

	private Long orderId;
	
	private String orderAmount;
	
	private LocalDateTime orderPlacedDate;
	
	private String orderStatus;
	
	private List<ProductDto> productList;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public LocalDateTime getOrderPlacedDate() {
		return orderPlacedDate;
	}

	public void setOrderPlacedDate(LocalDateTime orderPlacedDate) {
		this.orderPlacedDate = orderPlacedDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<ProductDto> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderPlacedDate=" + orderPlacedDate
				+ ", orderStatus=" + orderStatus + ", productList=" + productList + "]";
	}
	
	
}
