package com.shapara.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DailyFortuneService implements FortuneService {

	@Override
	public String GetFortuneService() {
		// TODO Auto-generated method stub
		return "it's you'r lucky day";
	}

}
