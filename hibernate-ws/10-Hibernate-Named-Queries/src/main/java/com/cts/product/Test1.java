package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Product;

public class Test1 {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();
		
		
		// level-1 cache - query data get stored inside session object - default
		// level-2 cache - query data get stored inside session factory object
		/*
		 * level -2 cache
		 * -------------------
		 * 	1. ehCache
		 * 	
		 */

		Session ses1 = sf.openSession();
		Session ses2 = sf.openSession();

		Product p1 = ses1.get(Product.class, 1);
		Product p2 = ses2.get(Product.class, 1);
		
		System.out.println(p1);
		System.out.println(p2);

	}

}
