package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Product;

public class AutoPKIncrement {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();
		Session ses1 = sf.openSession();
		
	
		Transaction tx=ses1.beginTransaction(); 

		
		Product prod = new Product();

		prod.setId(23);
		prod.setName("Watch");
		prod.setDescription("Apple Watch");
		prod.setPrice(65000);

		
		Product prod1 = new Product();

		prod1.setId(24);
		prod1.setName("Watch");
		prod1.setDescription("Samsung Watch");
		prod1.setPrice(55000);


		ses1.save(prod);
		ses1.save(prod1);

		// what ever objects available in ses1, commit them  to  database using tx object

		//ses1.beginTransaction().commit();
		
		tx.commit();

		System.out.println(">>>>> Done <<<<");

	}

}
