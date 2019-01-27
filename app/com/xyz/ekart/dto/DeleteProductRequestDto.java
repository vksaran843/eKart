package com.xyz.ekart.dto;

public class DeleteProductRequestDto {

	private Long productId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "DeleteProductRequestDto [productId=" + productId + "]";
	}
	
}
