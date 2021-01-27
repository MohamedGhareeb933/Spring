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

public class CreateInstructorDemo {

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
			
			String instructorBirthDay = "10/10/1980";
			Date date = DateUtil.parsedate(instructorBirthDay);
			instructor tempInstructor = new instructor("shapara", "ahmed", "shapara@gmail", date);
			instructorDetail tempInstructorDetail = new instructorDetail("shapara/youtube", "Coding");
			
			
			tempInstructor.setInstructorD(tempInstructorDetail);
			
			// start a transaction.
			session.beginTransaction();
			
			// this will Also save the Detail Object 
			// BECOUSE OF CASCADE TYPE ALL 
			session.save(tempInstructor);			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}

	}
}
