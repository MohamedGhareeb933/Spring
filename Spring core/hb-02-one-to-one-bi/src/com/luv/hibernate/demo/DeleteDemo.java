package com.luv.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv.hibernate.demo.entity.DateUtil;
import com.luv.hibernate.demo.entity.instructor;
import com.luv.hibernate.demo.entity.instructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create a session a factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(instructor.class)
										.addAnnotatedClass(instructorDetail.class)
										.buildSessionFactory();
		
		// create a session.
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start a transaction.
			session.beginTransaction();
			
			instructorDetail tempDetail =  session.get(instructorDetail.class, 2);
			
			// remove the associated object refrence 
			// break bi-directional link
			//tempDetail.getInstruct().setInstructorD(null);
			
			session.delete(tempDetail);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			sessionFactory.close();
		}

	}
}
