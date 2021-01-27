package com.luv.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create a session a factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create a session.
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start a transaction.
			session.beginTransaction();
			
			// update Student firstName 
			Student student = session.get(Student.class, 1);
			student.setFirstName("ahmed");
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
			// NEW CODE
			
			// create a new session and begin transaction.
			session = sessionFactory.getCurrentSession();	
			session.beginTransaction();
			
			System.out.println("updating Email for All Students");
			session.createQuery("update Student set email='goo@gmail.com' where id='1'").executeUpdate();
			
			// commit transaction.
			session.getTransaction().commit();

		}
		finally {
			sessionFactory.close();
		}

	}
}
