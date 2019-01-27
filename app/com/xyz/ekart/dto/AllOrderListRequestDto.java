package com.xyz.ekart.dto;

public class AllOrderListRequestDto {

	private Long customerId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "AllOrderListRequestDto [customerId=" + customerId + "]";
	}
	
}
