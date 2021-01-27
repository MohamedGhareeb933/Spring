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
import com.luv.hibernate.demo.entity.Student;

public class CreateReviewDemo {

	public static void main(String[] args) {
		
		// create a session a factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course course = session.get(Course.class, 1);
			
			course.addReview(new Review("this course is very usefull"));
			course.addReview(new Review("you must get this course"));
			course.addReview(new Review("Stupid course "));

			session.saveOrUpdate(course);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
