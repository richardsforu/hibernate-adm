package com.cts.product;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Category;
import com.cts.product.entity.Order;
import com.cts.product.entity.Product;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();
		
		Product p1=new Product("Pen", 250, "Red Ink");
		Product p2=new Product("Book", 340, "Java");
		Product p3=new Product("Mouse", 1200, "Dell Wired");
		Product p4=new Product("Mobile", 45000, "Samsung A3");
		Product p5=new Product("Laptop", 250000, "Mac Book Pro");
		
		Category c1=new Category();
		Category c2=new Category();
		Category c3=new Category();
		
		Order o1=new Order("James", LocalDateTime.now(), p1.getPrice(),p1);
		Order o2=new Order("James", LocalDateTime.now(), p2.getPrice(), p2);
		Order o3=new Order("James", LocalDateTime.now(), p3.getPrice(), p3);
		Order o4=new Order("Praveen", LocalDateTime.now(), p1.getPrice(), p1);
		Order o5=new Order("Praveen", LocalDateTime.now(), p2.getPrice(), p2);
		Order o6=new Order("Praveen", LocalDateTime.now(), p4.getPrice(), p4);
		Order o7=new Order("Praveen", LocalDateTime.now(), p5.getPrice(), p5);
		
		c1.setName("Electornics");
		c2.setName("Stationary");
		c3.setName("Grosaries");
		
		
		Set<Product> electronics=new HashSet<Product>();
		Set<Product> stationary=new HashSet<Product>();

		electronics.add(p3);
		electronics.add(p4);
		electronics.add(p5);
		
		stationary.add(p1);
		stationary.add(p2);
		
		/*
		c1.getProducts().add(p3);
		c1.getProducts().add(p4);
		c1.getProducts().add(p5);
		
		c2.getProducts().add(p1);
		c2.getProducts().add(p2);
		*/
		
		c1.setProducts(electronics);
		c2.setProducts(stationary);

		
		
		
		ses1.save(p1);
		ses1.save(p2);
		ses1.save(p3);
		ses1.save(p4);
		ses1.save(p5);
		
		ses1.save(c1);
		ses1.save(c2);
		
		
		ses1.save(o1);
		ses1.save(o2);
		ses1.save(o3);
		ses1.save(o4);
		ses1.save(o5);
		ses1.save(o6);
		ses1.save(o7);
		

		
		//ses1.beginTransaction().commit();
		

		
	}

}
