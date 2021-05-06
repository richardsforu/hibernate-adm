package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Product;

public class Delete {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();
		Session ses1 = sf.openSession();
		Transaction tx=ses1.beginTransaction(); 
		
		
		// Update operations
		// 1. find an the object which suppose to be updated using either load / get method
		
		Product p1 = ses1.get(Product.class, 90);
		
		
		// 3 call delete method  from ses1  for the p1 object to be deleted
		
		ses1.delete(p1);
		
		// 4. commit updated objects from session object into database
		
		tx.commit();
	
		System.out.println(">>>>> Done <<<<");

	}

}
