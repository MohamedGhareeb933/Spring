package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // Configuration Class
@EnableWebMvc // provides similar support to <mvc:annotatin-driven> To read @Controllers.
@ComponentScan(basePackages="com.luv2code.springsecurity.demo") // which packages to scan to look forward for Controllers
public class DemoAppConfig {
	
	// define a bean for a ViewResolver
	// this bean handle the prefix and suffix of the value returning from string controller EX:(/WEB-INF/view/"customer-list".jsp)
	@Bean
	public ViewResolver viewResolver() {
		
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

}
