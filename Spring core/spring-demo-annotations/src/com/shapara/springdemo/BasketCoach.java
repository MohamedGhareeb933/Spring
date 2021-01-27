package com.shapara.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// default bean id "FIRST LETTER IS LOWER CASE" , Specify Bean Id- @Component("BeanIdExample")
@Component
//@Scope("prototype")
public class BasketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${BasketCoach.name}")
	private String CoachName;
	@Value("${BasketCoach.age}")
	private String CoachAge;
	
	/*
	@Autowired  //  Field 
	@Qualifier("randomService")
	private FortuneService fortuneService;

	*/
	
	/*
	@Autowired // setter
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	@PostConstruct
	void DoStartUp() {
		System.out.println(">> BasketCoach : insdie DoStartUp Method ");
	}
	
	
	@PreDestroy
	void DoCleanUp() {
		System.out.println(">> BasketCoach : insdie DoCleanUp Method ");
	}
	
	@Autowired // Spring Will look at methods that Implements Fortune Service And Wireup
	BasketCoach(@Qualifier("randomService") FortuneService fortuneService){
		System.out.println(">> BasketCoach : inside Constructor with Arg");
		this.fortuneService = fortuneService;
	}

	@Override
	public String DoDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do 100 Ball Dribble";
	}

	@Override
	public String GetFortuneService() {
		// TODO Auto-generated method stub
		return fortuneService.GetFortuneService();
	}

	public String getCoachName() {
		return CoachName;
	}

	public String getCoachAge() {
		return CoachAge;
	}

}
