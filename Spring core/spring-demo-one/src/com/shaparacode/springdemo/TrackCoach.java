package com.shaparacode.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	private String CoachName;
	private String TeamName;
	
	public void setCoachName(String coachName) {
		CoachName = coachName;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	
	
	
	public String getCoachName() {
		return CoachName;
	}

	public String getTeamName() {
		return TeamName;
	}

	
	TrackCoach(FortuneService TheFortuneService){
		fortuneService = TheFortuneService;
	}
	
	@Override
	public String getDailyWork() {
		// TODO Auto-generated method stub
		return "Run Hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
