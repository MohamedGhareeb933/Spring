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

public class CreateInstructorDemo {

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
		
		// create a session.
		Session session = sessionFactory.getCurrentSession();
		
		try {
			String moBirth = "01/01/1990";
			Date date = DateUtil.parsedate(moBirth);
			
			Instructor instructor = new Instructor("Mohamed", "Ahmed", "mohamedAhmed@gmail.com", date);
			InstructorDetail instructorD = new InstructorDetail("Mohamed/Youtube", "Java/Hibernate");
			
			instructor.setInstructorD(instructorD);
			
			
			
			session.beginTransaction();
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
		}catch(Exception E) {
			
		}finally {
			session.close();
			sessionFactory.close();
		}
		

	}
}
