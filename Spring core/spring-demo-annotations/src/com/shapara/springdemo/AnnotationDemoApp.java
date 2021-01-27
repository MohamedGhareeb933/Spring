package com.shapara.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext Context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = Context.getBean("basketCoach", Coach.class);
		
		BasketCoach basketCoach = Context.getBean("basketCoach", BasketCoach.class);
		
		
		Context.close();
	}
}
