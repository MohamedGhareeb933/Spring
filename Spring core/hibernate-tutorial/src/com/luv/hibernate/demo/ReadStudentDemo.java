package com.luv.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv.hibernate.demo.entity.DateUtil;
import com.luv.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create a session a factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create a session.
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// create a Student Object
			System.out.println("Creating a Student object");
			
            String theDateOfBirthStr = "31/12/1998";
			Date theDate = DateUtil.parsedate(theDateOfBirthStr);
			
			Student student = new Student("mohamed", "ahmed", "mohamed@gmail", theDate);
						// start a transaction.
			session.beginTransaction();
			
			// save the Student object
			System.out.println("saveing Student Object ");
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
			// get a new session and begin transaction.
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve Student based on ID.
			Student tempStudent = session.get(Student.class, student.getId());
			System.out.println(tempStudent);
			
			// commit the transaction.
			session.getTransaction().commit();
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}

	}
}
