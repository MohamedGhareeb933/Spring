package com.luv.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			// query the Students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);
			
			System.out.println("\n\n");
			
			// query Students LastName is Ahmed.
			theStudents = session.createQuery("from Student s where s.lastName='ahmed' ").getResultList();
			displayStudents(theStudents);
			
			System.out.println("\n\n");
			
			// Query Student : firstName='malak' lastName='ghareeb'
			theStudents = session.createQuery("from Student s where s.firstName='malak' OR s.lastName='ghareeb' ").getResultList();
			displayStudents(theStudents);
			
			System.out.println("\n\n");
			
			//query Students where email LIKE '%gmail'
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail' ").getResultList(); // % means ends with 
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			sessionFactory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		// display the students.
		for	(Student index: theStudents) {
			System.out.println(index);
		}
	}
}
