package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Product;

public class Test {

	public static void main(String[] args) {

		// get session Factory

		SessionFactory sf = DBConfig.getSessionbFactory();

		// get Session

		Session ses1 = sf.openSession();
		
		// get transaction object
		
		Transaction tx=ses1.beginTransaction();

		// get Entity class info

		Product prod = new Product();

		prod.setId(22);
		prod.setName("Wire");
		prod.setDescription("100 mt");
		prod.setPrice(450);

		// CRUD operations

		// save / create object of a product

		ses1.save(prod);

		// what ever objects avaialbel in ses1, commit them  to  database using tx object

		//ses1.beginTransaction().commit();
		
		tx.commit();

		System.out.println(">>>>> Done <<<<");

	}

}
