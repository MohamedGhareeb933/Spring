package com.mohamed.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {
	
	public String getFortuneService() {
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		return "you need more CONCENTRATION";
	}
	
}
