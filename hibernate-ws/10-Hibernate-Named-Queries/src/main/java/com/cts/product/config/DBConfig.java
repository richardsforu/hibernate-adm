package com.cts.product.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.ehcache.jsr107.EhcacheCachingProvider;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.cts.product.entity.Category;
import com.cts.product.entity.Order;
import com.cts.product.entity.Product;

import net.sf.ehcache.hibernate.EhCacheRegionFactory;

public class DBConfig {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionbFactory() {

		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

		Properties props = new Properties();
		try {
			props.load(ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HashMap<String, Object> settings = new HashMap<String, Object>();

		settings.put(Environment.DRIVER, props.getProperty("mysql.driver"));
		settings.put(Environment.URL, props.getProperty("mysql.url"));
		settings.put(Environment.USER, props.getProperty("mysql.user"));
		settings.put(Environment.PASS, props.getProperty("mysql.password"));
		settings.put(Environment.DIALECT, props.getProperty("mysql.dialect"));
		settings.put(Environment.SHOW_SQL, props.getProperty("show.sql"));
		settings.put(Environment.HBM2DDL_AUTO, props.getProperty("hbm2ddl.auto"));
		settings.put(Environment.FORMAT_SQL, props.getProperty("format.sql"));
		//settings.put(Environment.CACHE_REGION_FACTORY,EhCacheRegionFactory.class);
		//settings.put(Environment.USE_SECOND_LEVEL_CACHE, true);
		//settings.put(Environment.CACHE_PROVIDER_CONFIG, EhcacheCachingProvider.class);

		// Specify cache region factory class
        //settings.put(Environment.CACHE_REGION_FACTORY, JCacheRegionFactory.class);

		

		registryBuilder.applySettings(settings);

		registry = registryBuilder.build();

		MetadataSources metadataSources = new MetadataSources(registry);
		metadataSources.addAnnotatedClass(Product.class);
		metadataSources.addAnnotatedClass(Order.class);
		metadataSources.addAnnotatedClass(Category.class);

		Metadata metadata = metadataSources.getMetadataBuilder().build();

		sessionFactory = metadata.buildSessionFactory();

		return sessionFactory;
	}

}
