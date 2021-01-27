package com.shapara.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shapara.employe.Employe;

public class CreateEmploye {

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
			
			// save employe object into table 
			Employe employe = new Employe("mohamed", "ahmed", "google");
			Employe employe2 = new Employe("mostafa", "ahmed", "microsoft");
			Employe employe3 = new Employe("ahmed", "ghareeb", "amazon");
			
			session.save(employe);
			
			// commit session
			session.getTransaction().commit();
		} 
		finally{
			session.close();
		}
	}

}
