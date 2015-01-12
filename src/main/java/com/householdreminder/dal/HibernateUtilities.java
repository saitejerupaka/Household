package com.householdreminder.dal;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {
 private static SessionFactory sessionFactory;
 private static StandardServiceRegistryBuilder serviceRegistryBuilder;
 
 static
 {
	 try{
	 Configuration config = new Configuration().configure();
	 serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
	 ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
	 sessionFactory = config.buildSessionFactory(serviceRegistry);
	 }
	 catch(HibernateException ex)
	 {
		 System.out.println(ex.getMessage()); 
	 }
 }
 
 public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}
 
}
