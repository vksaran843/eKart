package com.xyz.ekart.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.ebean.Model;

@Entity
@Table(name="ITEM_ORDER")
public class Order extends Model{

	@Id
	@Column(name ="ORDER_ID")
	private Long orderId;
	
	@Column(name ="ORDER_STATUS")
	private String orderStatus;
	
	@ManyToOne
	@JoinColumn(name ="CUSTOMER_ID")
	private Customer customerId;
	
	@Column(name ="ORDER_CREATED_DATE")
	private LocalDateTime orderCreatedDate;
	
	@Column(name ="ORDER_MODIFIED_DATE")
	private LocalDateTime orderModifiedDate;
	
	@Column(name ="ORDER_AMOUNT")
	private String orderAmount;
	
	@Column(name ="PAYMENT_MODE")
	private String paymentMode;
	
	@Column(name ="PAYMENT_STATUS")
	private String paymentStatus;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}


	public LocalDateTime getOrderCreatedDate() {
		return orderCreatedDate;
	}

	public void setOrderCreatedDate(LocalDateTime orderCreatedDate) {
		this.orderCreatedDate = orderCreatedDate;
	}

	public LocalDateTime getOrderModifiedDate() {
		return orderModifiedDate;
	}

	public void setOrderModifiedDate(LocalDateTime orderModifiedDate) {
		this.orderModifiedDate = orderModifiedDate;
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

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", customerId=" + customerId
				+ ", orderCreatedDate=" + orderCreatedDate + ", orderModifiedDate=" + orderModifiedDate
				+ ", orderAmount=" + orderAmount + ", paymentMode=" + paymentMode + ", paymentStatus=" + paymentStatus
				+ "]";
	}
	
	
	
}
