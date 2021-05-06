package com.cts.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name = "s1",strategy = "com.cts.product.utils.CustomPKGen")
public class Product {

	@Id
	@Column(name = "prod_id")
	@GeneratedValue(generator = "s1")
	private String prodId; // ABCHYD19729734944894
	@Column(name = "prod_name", length = 30)
	private String prodName;
	private double price;

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
