package com.shaparacode.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load spring configuration file 
		ClassPathXmlApplicationContext Context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve the bean from the Container 
		Coach theCoach = Context.getBean("BaseBallCoach", Coach.class);
		Coach alphaCoach = Context.getBean("BaseBallCoach", Coach.class);
		
		Boolean Scope = (theCoach == alphaCoach);
		
		System.out.println("is two instance is equal : " + Scope);
		System.out.println("memory address of theCoach: " + theCoach);
		System.out.println("memory address of alphaCoach: " + alphaCoach);
		
		// close the Context. 
		Context.close();
	}

}
