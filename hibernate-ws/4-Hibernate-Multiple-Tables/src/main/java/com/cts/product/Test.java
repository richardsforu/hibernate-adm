package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Employee;
import com.cts.product.entity.Product;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();

		Transaction tx = ses1.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("Praveen");
		e1.setSalary(8347434);
		e1.setDeptName("Training");
		e1.setLoc("Chennai");
		
		e1.setProjName("Ford");
		e1.setClientName("Motors");
		
		ses1.save(e1);

		tx.commit();

		System.out.println(">>>>> Done <<<<");

	}

}
