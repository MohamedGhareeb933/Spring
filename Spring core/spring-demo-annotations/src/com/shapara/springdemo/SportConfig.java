package com.shapara.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.shapara.springdemo")
@PropertySource("classpath:Sport.Properties")
public class SportConfig {

	@Bean
	public FortuneService randomService() {
		return new RandomService();
	}
	
	@Bean
	public Coach swimCoach() {
		Coach theSwimCoach = new SwimCoach(randomService());
		
		return theSwimCoach;
	}
	
}
