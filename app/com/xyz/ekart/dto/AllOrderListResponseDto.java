package com.xyz.ekart.dto;

import java.util.List;

public class AllOrderListResponseDto {
	
	private Long customerId;
	
	private List<OrderDto> orderList;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<OrderDto> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderDto> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "AllOrderListResponseDto [customerId=" + customerId + ", orderList=" + orderList + "]";
	}
}
