package com.cts.product;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Product;

public class AutoKey {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();
		
		Session ses1 = sf.openSession();
		
	
		Transaction tx=ses1.beginTransaction(); 
		
		Customer cust=new Customer();
		cust.setCustName("Praveen");
		cust.setDob(LocalDate.of(1984, 8, 28));

		ses1.save(cust);
		
		tx.commit();

		System.out.println(">>>>> Done <<<<");

	}

}
