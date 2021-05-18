package com.cts.product.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "q1", query = "from Product")
@NamedQuery(name="q2",query = "from Category")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private int productId;
	private String name;
	private double price;
	private String description;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", description="
				+ description + "]";
	}
	
	

}
