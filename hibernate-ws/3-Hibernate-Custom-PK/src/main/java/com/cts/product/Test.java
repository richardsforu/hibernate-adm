package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Product;

public class Test {

	public static void main(String[] args) {



		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();
		
		Transaction tx=ses1.beginTransaction(); 
		
		
		Product p1=new Product();
		// id ????
		p1.setProdName("Laptop");
		p1.setPrice(55000);
		
		ses1.save(p1);
		tx.commit();


		System.out.println(">>>>> Done <<<<");

	}

}
