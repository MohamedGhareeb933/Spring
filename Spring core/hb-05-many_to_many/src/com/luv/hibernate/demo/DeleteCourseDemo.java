package com.luv.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv.hibernate.demo.entity.Course;
import com.luv.hibernate.demo.entity.Instructor;
import com.luv.hibernate.demo.entity.InstructorDetail;
import com.luv.hibernate.demo.entity.Review;
import com.luv.hibernate.demo.entity.Student;

public class DeleteCourseDemo {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
						

			session.beginTransaction();
			
			Course course = session.get(Course.class, 1);
			System.out.println("Deleting Course" + course);
			session.delete(course);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
