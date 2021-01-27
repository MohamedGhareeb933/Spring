package com.luv.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// Delete student at id 2
			Student student = session.get(Student.class, 2);
			session.delete(student);
			
			// ALTERNATE WAY 
			// Delete Student at id 1
			session.createQuery("delete from Student where id=1 ").executeUpdate();					

			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			sessionFactory.close();
		}

	}
}
