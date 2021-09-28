package com.luv.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv.hibernate.demo.entity.Course;
import com.luv.hibernate.demo.entity.instructor;
import com.luv.hibernate.demo.entity.instructorDetail;

public class FetchJoinDemo {

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
			
			int id = 2;
			// start a transaction.
			session.beginTransaction();
			
			//HQL // select from instructor - JOIN FETCH (and all associated columns) -> CourseList of the id 2 
			Query<instructor> query = session.createQuery("select i from instructor i JOIN FETCH i.courseList where i.id=:instruct", instructor.class);
			
			query.setParameter("instruct", id);
			
			instructor tempInstructor=  query.getSingleResult();
			
			System.out.println(tempInstructor);
			
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
