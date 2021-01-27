package com.mohamed.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {
	
	public String getFortuneService() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		return "you need more CONCENTRATION";
	}
 
	public String getFortuneService(boolean b) {
		
		if(b) {
			throw new RuntimeException("Error please Fix ");
		}
		
		
		return getFortuneService();
	}
	
}
