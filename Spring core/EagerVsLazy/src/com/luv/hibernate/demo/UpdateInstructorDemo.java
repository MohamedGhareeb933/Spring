package com.luv.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv.hibernate.demo.entity.Course;
import com.luv.hibernate.demo.entity.DateUtil;
import com.luv.hibernate.demo.entity.instructor;
import com.luv.hibernate.demo.entity.instructorDetail;

public class UpdateInstructorDemo {

	public static void main(String[] args) {
		
		// create a session a factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(instructor.class)
										.addAnnotatedClass(instructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		
		// create a session.
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start a transaction.
			session.beginTransaction();
			
			instructor tempInstructor = session.get(instructor.class, 1);
			tempInstructor.addCourse(session.get(Course.class, 1));
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}

	}
}
