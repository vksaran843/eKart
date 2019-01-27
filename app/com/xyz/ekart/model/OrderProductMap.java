package com.xyz.ekart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.ebean.Model;

@Entity
@Table(name="ORDER_PRODUCT_MAP")
public class OrderProductMap extends Model{

	@Id
	@Column(name ="ORDER_PRODUCT_MAP_ID")
	private Long orderProductMapId;

	@ManyToOne
	@JoinColumn(name ="ORDER_ID")
	private Order orderId;
	
	@ManyToOne
	@JoinColumn(name ="PRODUCT_ID")
	private Product productId;

	@Column(name ="PRODUCT_QUANTITY")
	private Long productQuantity;

	@Column(name ="TOTAL_AMOUNT")
	private String totalAmount;

	public Long getOrderProductMapId() {
		return orderProductMapId;
	}

	public void setOrderProductMapId(Long orderProductMapId) {
		this.orderProductMapId = orderProductMapId;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "OrderProductMap [orderProductMapId=" + orderProductMapId + ", orderId=" + orderId + ", productId="
				+ productId + ", productQuantity=" + productQuantity + ", totalAmount=" + totalAmount + "]";
	}
	
	
}
