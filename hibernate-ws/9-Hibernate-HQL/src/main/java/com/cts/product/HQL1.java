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

public class HQL1 {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();
		
		String q1="from Product";
		
		Query<Product> qry1=ses1.createQuery(q1);
		
		qry1.getResultList().forEach(product->{
			System.out.println(product.getProductId());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getDescription());
			System.out.println("----------------------------");
		});
		
		

		
	}

}
