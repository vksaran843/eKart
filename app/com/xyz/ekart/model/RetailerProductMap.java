package com.xyz.ekart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.ebean.Model;

@Entity
@Table(name="RETAILER_PRODUCT_MAP")
public class RetailerProductMap extends Model{

	@Id
	@Column(name ="RETAILER_PRODUCT_MAP_ID")
	private Long retailerProductMapId;
	
	@ManyToOne
	@JoinColumn(name ="RETAILER_ID")
	private Retailer retailerId;
	
	@ManyToOne
	@JoinColumn(name ="PRODUCT_ID")
	private Product productId;
	
	@Column(name ="RETAILER_BASE_PRICE")
	private String retailerBasePrice;
	
	@Column(name ="DISCOUNT")
	private String discount;
	
	@Column(name ="QUANTITY")
	private Long quantity;

	public Long getRetailerProductMapId() {
		return retailerProductMapId;
	}

	public void setRetailerProductMapId(Long retailerProductMapId) {
		this.retailerProductMapId = retailerProductMapId;
	}

	public Retailer getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(Retailer retailerId) {
		this.retailerId = retailerId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public String getRetailerBasePrice() {
		return retailerBasePrice;
	}

	public void setRetailerBasePrice(String retailerBasePrice) {
		this.retailerBasePrice = retailerBasePrice;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "RetailerProductMap [retailerProductMapId=" + retailerProductMapId + ", retailerId=" + retailerId
				+ ", productId=" + productId + ", retailerBasePrice=" + retailerBasePrice + ", discount=" + discount
				+ ", quantity=" + quantity + "]";
	}
	
}
