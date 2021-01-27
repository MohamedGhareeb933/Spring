package com.shaparacode.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemo {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext Context = 
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		baseballcoach baseball = Context.getBean("BaseBallCoach", baseballcoach.class);
		
		Context.close();

	}

}
