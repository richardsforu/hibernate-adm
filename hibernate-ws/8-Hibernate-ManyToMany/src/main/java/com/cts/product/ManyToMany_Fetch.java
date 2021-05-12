package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Course;
import com.cts.product.entity.Student;
public class ManyToMany_Fetch {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();
		
		Course course = ses1.get(Course.class, 1);
	
		
		System.out.println(course);
		for(Student student:course.getStudents()) {
			System.out.println(student);
		}
		
		
		
		
		
		
	}

}
