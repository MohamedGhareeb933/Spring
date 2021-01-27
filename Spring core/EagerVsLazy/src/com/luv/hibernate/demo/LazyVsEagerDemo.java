package com.luv.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv.hibernate.demo.entity.Course;
import com.luv.hibernate.demo.entity.instructor;
import com.luv.hibernate.demo.entity.instructorDetail;

public class LazyVsEagerDemo {

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
			
			instructor tempInstructor = session.get(instructor.class, 2);
			
			System.out.println("Instructor : " + tempInstructor);
			
			List<Course> CourseList= new ArrayList<>(tempInstructor.getCourseList());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
			session.close();

			//System.out.println("instructor Courses" + tempInstructor.getCourseList());
			System.out.println(CourseList);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}

	}
}
