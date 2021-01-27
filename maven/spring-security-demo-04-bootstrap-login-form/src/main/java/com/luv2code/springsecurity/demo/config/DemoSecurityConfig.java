package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration // Configuration Class
@EnableWebSecurity // to extend WebSecurityConfigurerAdapter and overriding individual methods
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add users for memory authentication.
		// default password use plain text 
		// TODO - WARNING This method is considered unsafe for production and is only intended for sample applications. 
		UserBuilder user = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(user.username("mohamed").password("test123").roles("EMPLOYEE"))
		.withUser(user.username("asser").password("test123").roles("MANAGER"))
		.withUser(user.username("ayten").password("test123").roles("ADMIN"));
	}

	// The most basic configuration defaults to automatically generating a login page at the URL "/login", redirecting to "/login?error" for authentication failure
	// configure Security of web paths in application , login and logout such as custom login form 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // restrict access based on the httpServletRequest 
			.antMatchers("/css/**").permitAll() //Configure Spring Security to allow unauthenticated requests (permit all)to the "/css" directory
			.anyRequest().authenticated() // any request to the app must be authenticated ie logged in 
			.and() 
			.formLogin() // customizing the login form instead of the default login form 
			.loginPage("/showMyLoginPage") // show custom form from @RequestMapping ("/showMyLoginPage") url 
			.loginProcessingUrl("/authenticateTheUser") // login form should POST data to the url (check the username and password)
			.permitAll() // allow every one 
			.and()
			.logout().permitAll(); // add logout support for default URL /logout.
	}
	
	
}
