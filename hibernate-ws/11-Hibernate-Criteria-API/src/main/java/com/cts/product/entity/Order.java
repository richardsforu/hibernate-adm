package com.cts.product.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity(name = "orders")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private long orderId;
	@Column(name = "customer_name", length = 30)
	private String customerName;
	@Column(name = "purchase_date")
	private LocalDateTime purchaseDate;
	private double amount;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Order(String customerName, LocalDateTime purchaseDate, double amount, Product product) {
		this.customerName = customerName;
		this.purchaseDate = purchaseDate;
		this.amount = amount;
		this.product = product;
	}



	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
