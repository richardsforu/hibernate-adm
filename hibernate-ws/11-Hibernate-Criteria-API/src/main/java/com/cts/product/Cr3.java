package com.cts.product;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Category;
import com.cts.product.entity.Order;
import com.cts.product.entity.Product;

public class Cr3 {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();
	
		Criteria prod = ses1.createCriteria(Category.class);
		Criteria orderts=prod.createCriteria("products");
		orderts.add(Restrictions.eq("productId", 3));
		List<?> results=prod.list();
		
		//System.out.println(results);
		
		
		results.forEach(cat->{
			System.out.println(cat);
		});

		
	}

}
