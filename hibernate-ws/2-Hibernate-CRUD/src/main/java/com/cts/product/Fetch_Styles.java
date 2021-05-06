package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Product;

public class Fetch_Styles {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();
		Session ses1 = sf.openSession();
		Transaction tx=ses1.beginTransaction(); 
		
		
		// Finding object with ID
		
		/**
		 *     fetching operations
		 *     ------------------------
		 *     1. Single row operations
		 *     2. multi row operations
		 * 
		 * 
		 *  1. Single row operations
		 *  ------------------------------
		 * 1. Lazy loading
		 * 		-> load method
		 * 2. Eager loading
		 * 		-> get method
		 * 
		 *  2. multi row operations
		 *  --------------------------
		 *  	1. HQL
		 *  	2. Criteria API
		 *  	3. Native SQL
		 * 
		 */

		
		// Find an object in Product table using product ID
		
		// Eager style / fetch style
		//----------------------------------
		
	     Product p1 = ses1.get(Product.class, 220); // eager
		 
	    // Product p1 = ses1.load(Product.class, 220); // lazy

		
	     System.out.println(p1.getName());
		
		 /*
		
		 System.out.println(p1.getId());
		 System.out.println(p1.getName());
		 System.out.println(p1.getPrice());
		 System.out.println(p1.getDescription());
		 
		 */
	

		System.out.println(">>>>> Done <<<<");

	}

}
