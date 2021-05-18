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

public class Cr2 {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();
		
		Criteria crit = ses1.createCriteria(Product.class);
		//crit.addOrder(org.hibernate.criterion.Order.asc("price"));
		
		//crit.setMaxResults(2);
		//crit.add(Restrictions.between("productId", 1, 2));
		//crit.add(Restrictions.like("name","%e%"));
		//crit.add(Restrictions.lt("price", 2000.00));



		List<Product> products = crit.list();

		products.forEach(product -> {
			System.out.println(product.getProductId());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getDescription());
			System.out.println("----------------------------");
		});

	}

}
