package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Product;

public class SaveOrUpdate {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();
		Session ses1 = sf.openSession();
		Transaction tx=ses1.beginTransaction();
		
		// Update operations
		// 1. find an the object which suppose to be updated using either load / get method
		
		//Product p1 = ses1.get(Product.class, 90);
		
		Product p1=new Product(); // Transient state - not connected / synched to DB
		
		p1.setId(5);
		
		// 2. set the data to p1 object what you wanted to update
		
		p1.setName("Smart Phone");
		p1.setDescription("Samsung A7 Mobile");
		p1.setPrice(45000);
		
		
		// 3 call update method  from ses1 on for the p1 object
		
		ses1.saveOrUpdate(p1); // persistent state
		
		//ses1.clear(); 
		//ses1.evict(p1);
		//ses1.detach(p1);
	
		//ses1.close(); // / detached .. 
		
		//ses1.merge(p1);
		
		
		ses1.delete(p1); // ?
		
		
		
		// 4. commit updated objects from session object into database
		
		tx.commit();
	
		System.out.println(">>>>> Done <<<<");

	}

}
