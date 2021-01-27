package com.mohamed.aopdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.mohamed.aopdemo.dao.AccountDAO;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.mohamed.aopdemo")
public class demoConfig {
	
	@Bean
	Account account() {
		return new Account("Mohamed", "senior");
	}
}
