package com.luv.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv.hibernate.demo.entity.DateUtil;
import com.luv.hibernate.demo.entity.instructor;
import com.luv.hibernate.demo.entity.instructorDetail;

public class CreateDemo {

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
			// create a instructor Object
            String theDateOfBirthStr = "31/12/1998";
			Date theDate = DateUtil.parsedate(theDateOfBirthStr);
			
			instructor instructor1 = new instructor("mohamed", "ahmed", "mohamed@gmail", theDate);
			instructorDetail instructor1Detail = new instructorDetail("ShapraChanel", "Swimming");
			
			instructor1.setInstructorD(instructor1Detail);
			
			// start a transaction.
			session.beginTransaction();
			
			// this will Also save the Detail Object 
			// BECOUSE OF CASCADE TYPE ALL 
			System.out.println("Savintg Instructor Object" + instructor1);
			session.save(instructor1);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}

	}
}
