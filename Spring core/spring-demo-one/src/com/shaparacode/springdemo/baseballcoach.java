package com.shaparacode.springdemo;

public class baseballcoach implements Coach {
	
	// Define a private field for Dependency
	private FortuneService fortuneService;

	// define a Setter method for Dependency injection.
	public void setFortuneService(FortuneService TheFortuneService) {
		System.out.println("BaseBallCoach : Setter Method - arg.");
		this.fortuneService = TheFortuneService;
	}
	
	// create an init method
	public void doMyStartup() {
		System.out.println("baseballcoach: inside doMyStartup");
	}
	// create a destroy method
	public void doMyCleanup() {
		System.out.println("baseballcoach: inside doMyCleanup");
	}
	
	
	@Override
	public String getDailyWork() {
		return "Spend 30 Min on Practice";
	}

	@Override
	public String getDailyFortune() {
		// Dependency helper
		return fortuneService.getFortune();
	}

}
