package com.cts.product;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Category;
import com.cts.product.entity.Order;
import com.cts.product.entity.Product;

public class HQL4 {


	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();
		
		// multiple column fetch
		
		String q1="select prod.productId,prod.name,prod.price from Product prod";
		
		Query<Object[]> qry1=ses1.createQuery(q1);
		
		// eager fetch with list
		
		/*
		List<Object[]> rows=qry1.list();
		
		for(Object[] row:rows) {

			for(Object col:row) {
					System.out.print(col+"\t");
			}
			System.out.println();
			
		}
		
		*/
		
		
		// lazy fetch with iterate 
	
		Iterator<Object[]> it= qry1.iterate();
		
		while(it.hasNext()) {
			Object[] cols=it.next();
			for(Object col:cols) {
				System.out.println(col);
			}
			System.out.println("--------------------------");
		}
	
		
		
		
		

		
	}

}
