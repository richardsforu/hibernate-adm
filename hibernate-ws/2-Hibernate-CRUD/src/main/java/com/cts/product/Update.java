package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Product;

public class Update {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();
		Session ses1 = sf.openSession();
		Transaction tx=ses1.beginTransaction(); 
		
		
		// Update operations
		// 1. find an the object which suppose to be updated using either load / get method
		
		Product p1 = ses1.get(Product.class, 9);
		
		// 2. set the data to p1 object what you wanted to update
		
		p1.setName("Smart Phone");
		p1.setDescription("Samsung A7 Mobilee");
		p1.setPrice(35000);
		
		
		// 3 call update method  from ses1 on for the p1 object
		
		ses1.update(p1);
		
		// 4. commit updated objects from session object into database
		
		tx.commit();
	
		System.out.println(">>>>> Done <<<<");

	}

}
