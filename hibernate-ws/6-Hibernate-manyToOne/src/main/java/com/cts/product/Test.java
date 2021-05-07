package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Department;
import com.cts.product.entity.Employee;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();

		Transaction tx = ses1.beginTransaction();

		Department d1 = new Department("HR", "Chennai");
		Department d2 = new Department("Accounts", "Pune");
		Department d3 = new Department("Training", "Hyderabad");

		Employee e1 = new Employee("Praveen", 15000);
		Employee e2 = new Employee("James", 25000);
		Employee e3 = new Employee("Bucky", 16000);
		Employee e4 = new Employee("Rose", 12000);
		Employee e5 = new Employee("David", 19000);
		Employee e6 = new Employee("Raju", 24000);

		
		e1.setDept(d1);
		e2.setDept(d1);
		
		e3.setDept(d2);
		
		e4.setDept(d3);
		e5.setDept(d3);
		e6.setDept(d3);
		
		

		ses1.save(e1);
		ses1.save(e2);
		ses1.save(e3);
		ses1.save(e4);
		ses1.save(e5);
		ses1.save(e6);
		
		tx.commit();

	}

}
