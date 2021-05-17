package com.cts.product;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Category;
import com.cts.product.entity.Order;
import com.cts.product.entity.Product;

public class HQL3 {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();
		
		// Single column
		
		String q1="select prod.productId from Product prod";
		
		Query<Object> qry1=ses1.createQuery(q1);
		
		qry1.getResultList().forEach(column->{
			System.out.println(column);
		});
		
		

		
	}

}
