package com.cts.product.utils;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomPKGen implements IdentifierGenerator{
	
	
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		String pk=null;
		
		long time=System.currentTimeMillis();
		
		pk="ABCHYD"+time;			
		
		return pk;
	}

}
