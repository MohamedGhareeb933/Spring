package com.shapara.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shapara.employe.Employe;

public class UpdateEmploye {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employe.class)
										.buildSessionFactory();
		
		//create Session								
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start Session
			session.beginTransaction();
			
			Employe employe = session.get(Employe.class, 1);
			employe.setFirstName("ahmed");
			session.saveOrUpdate(args);
			
			// commit session
			session.getTransaction().commit();
		} 
		finally{
			session.close();
		}
	}

	
}
