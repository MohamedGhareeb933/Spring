package com.luv.hibernate.demo;

import java.text.ParseException;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv.hibernate.demo.entity.Course;
import com.luv.hibernate.demo.entity.DateUtil;
import com.luv.hibernate.demo.entity.Instructor;
import com.luv.hibernate.demo.entity.InstructorDetail;
import com.luv.hibernate.demo.entity.Review;

public class DeleteSession {

	public static void main(String[] args) {
		
		// create a session a factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.buildSessionFactory();
		
		// create a session.
		Session session = sessionFactory.getCurrentSession();
		
		try{
			// start a transaction.
			session.beginTransaction();
			
			//Instructor instructor = session.get(Instructor.class, 2);
			//InstructorDetail instructorDetail = instructor.getInstructorD();
			//instructorDetail.setInstruct(null);
			
			session.delete(session.get(Course.class , 3));
			
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
