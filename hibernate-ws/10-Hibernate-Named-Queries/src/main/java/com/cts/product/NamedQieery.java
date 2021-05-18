package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Product;

public class NamedQieery {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses = sf.openSession();
		
		Query<Product> namedQuery = ses.createNamedQuery("q1");
		
		NativeQuery<?> nq = ses.createNativeQuery("select * from product");

		namedQuery.list().forEach(product -> {
			System.out.println(product.getProductId());
			System.out.println(product.getName());
			System.out.println("---------------------------");
		});
		
		System.out.println("============================================");
		
		nq.addEntity(Product.class);
		
		nq.getResultList().forEach(product -> {
			
			System.out.println(product);
		});

	}

}
