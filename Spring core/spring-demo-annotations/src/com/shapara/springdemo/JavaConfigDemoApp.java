package com.shapara.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext Context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach swimCoach = Context.getBean("swimCoach", Coach.class);
		
		SwimCoach theSwimCoach = Context.getBean("swimCoach", SwimCoach.class);

		System.out.println(swimCoach.GetFortuneService());
		
		System.out.println(theSwimCoach.getName());
		
		
		Context.close();
	}
}
