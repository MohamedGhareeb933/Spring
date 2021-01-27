package com.shapara.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${SwimCoach.name}")
	private String name;
	
	@Value("${SwimCoach.age}")
	private String age;
	
	SwimCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}

	@Override
	public String DoDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do 50 Meter back Swimming Twice";
	}

	@Override
	public String GetFortuneService() {
		// TODO Auto-generated method stub
		return fortuneService.GetFortuneService();
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}
	
}
