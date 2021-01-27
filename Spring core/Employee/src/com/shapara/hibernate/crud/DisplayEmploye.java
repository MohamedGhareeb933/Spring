package com.shapara.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shapara.employe.Employe;

public class DisplayEmploye {

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
			
			// Display Employe object 
			List<Employe> employes = session.createQuery("from Employe").getResultList();
			for(Employe Index : employes) {
				System.out.println(Index);
			}			
			// commit session
			session.getTransaction().commit();
		} 
		finally{
			session.close();
		}
	}

	private static void displayEmployes(List<Employe> employes) {
		for(Employe Index : employes) {
			System.out.println(Index);
		}
	}

}
