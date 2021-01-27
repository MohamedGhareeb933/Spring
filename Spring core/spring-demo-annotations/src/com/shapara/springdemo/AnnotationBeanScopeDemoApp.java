package com.shapara.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load Spring Config File
		ClassPathXmlApplicationContext Context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from Spring container
		Coach AlphaCoach = Context.getBean("basketCoach", Coach.class);
		Coach BetaCoach = Context.getBean("basketCoach", Coach.class);
		
		System.out.println(AlphaCoach.DoDailyWorkout());
		System.out.println(BetaCoach.DoDailyWorkout());

		Context.close();
	}

}
