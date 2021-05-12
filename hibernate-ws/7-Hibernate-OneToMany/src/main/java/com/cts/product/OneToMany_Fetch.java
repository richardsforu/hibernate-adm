package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Department;
import com.cts.product.entity.Employee;

public class OneToMany_Fetch {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();
		Department dept = ses1.get(Department.class,9);
		
		System.out.println(dept);
		
		for(Employee emp:dept.getEmps()) {
			System.out.println(emp);
		}

		
		
		
		
		
		
	}

}
