package com.shaparacode.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load Spring Config File  
		ClassPathXmlApplicationContext Context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve the bean from spring Container
		Coach BaseBallCoach = Context.getBean("BaseBallCoach", Coach.class);
		TrackCoach TrackCoach = Context.getBean("TrackCoach", TrackCoach.class);
		
		//call methods on the beans
		System.out.println(TrackCoach.getDailyWork());
		System.out.println(TrackCoach.getDailyFortune());
		
		System.out.println(TrackCoach.getTeamName() + " " + TrackCoach.getCoachName());
		
		
		
		
		//close the context
		Context.close();
	}

}
