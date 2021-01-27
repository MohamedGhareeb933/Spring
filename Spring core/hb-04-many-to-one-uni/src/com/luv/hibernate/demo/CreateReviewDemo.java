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

public class CreateReviewDemo {

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
		
		try {
			
			// start a transaction.
			session.beginTransaction();

			Course course = session.get(Course.class, 4);
			
			course.addReview(new Review("this course is Awesome i gave it 4 statrs "));
			course.addReview(new Review("many usefull information  "));
			course.addReview(new Review("you should take this course "));
			course.addReview(new Review("5 of 5 "));
			
			
			System.out.println("updating the Course ");
			System.out.println("course: " + course);
			System.out.println("reviews" +  course.getReviewList());
			
			session.update(course);
			
			
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
