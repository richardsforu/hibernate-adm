package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Course;
import com.cts.product.entity.Student;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();

		Transaction tx = ses1.beginTransaction();

		Student s1 = new Student("Praveen", 87657644);
		Student s2 = new Student("Prashath", 87657647);
		Student s3 = new Student("Jeeva", 87657643);
		Student s4 = new Student("Saravanan", 87657641);
		Student s5 = new Student("Hema", 87657645);
		Student s6 = new Student("Pavani", 87657649);

		Course java = new Course("Java", 1200);
		Course ui = new Course("UI-Technologies", 1300);
		Course js = new Course("Java Scriptq", 8843);

		
		/*
		s1.getCourses().add(java);
		s1.getCourses().add(ui);
		s1.getCourses().add(js);

		s2.getCourses().add(java);
		s2.getCourses().add(ui);
		s2.getCourses().add(js);

		s3.getCourses().add(java);

		s4.getCourses().add(java);
		s4.getCourses().add(js);

		s5.getCourses().add(js);

		s6.getCourses().add(js);
		s6.getCourses().add(ui);
		
		*/
		
		java.getStudents().add(s1);
		java.getStudents().add(s2);
		java.getStudents().add(s3);
		java.getStudents().add(s4);
		java.getStudents().add(s5);
		java.getStudents().add(s6);
		
		
		js.getStudents().add(s2);
		js.getStudents().add(s6);
		js.getStudents().add(s3);
		
		ui.getStudents().add(s1);
		ui.getStudents().add(s4);
		ui.getStudents().add(s2);
		ui.getStudents().add(s5);



		ses1.save(java);
		ses1.save(ui);
		ses1.save(js);

		
	

		//ses1.save(s1);
		//ses1.save(s2);
		//ses1.save(s3);
		//ses1.save(s4);
		//ses1.save(s5);
		//ses1.save(s6);

		tx.commit();

	}

}
