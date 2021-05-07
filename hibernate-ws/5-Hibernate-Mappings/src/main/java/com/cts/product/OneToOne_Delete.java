package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Department;
import com.cts.product.entity.Employee;

public class OneToOne_Delete {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();
		Employee e1 = ses1.get(Employee.class,6);

		//e1.setDept(d1);
		ses1.delete(e1);
		
		ses1.beginTransaction().commit();
		
		
	}

}
