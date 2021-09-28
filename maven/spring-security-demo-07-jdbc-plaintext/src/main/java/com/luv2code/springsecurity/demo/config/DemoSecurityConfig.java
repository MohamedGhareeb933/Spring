package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration // Configuration Class
@EnableWebSecurity // to extend WebSecurityConfigurerAdapter and overriding individual methods
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// auto wire the DataSource Bean in the demoAppConfig
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// use jdbc authentication...
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	// The most basic configuration defaults to automatically generating a login page at the URL "/login", redirecting to "/login?error" for authentication failure
	// configure Security of web paths in application , login and logout such as custom login form 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests() // restrict access based on the httpServletRequest 
			//.anyRequest().authenticated() // any request to the app must be authenticated ie logged in 
			.antMatchers("/css/**").permitAll() //Configure Spring Security to allow unauthenticated requests (permit all)to the "/css" directory
			.antMatchers("/").hasRole("EMPLOYEE") // allow user with Role(s) "EMPLOYEE" to access the home page 
			.antMatchers("/leaders/**").hasRole("MANAGER") // allow user with Role(s) "MANAGER" TO access leaders page
			.antMatchers("/admins/**").hasRole("ADMIN") // allow user with Role(s) "ADMIN" to access admin page. 
			.and() 
			.formLogin() // customizing the login form instead of the default login form 
			.loginPage("/showMyLoginPage") // show custom form from @RequestMapping ("/showMyLoginPage") url
			.loginProcessingUrl("/authenticateTheUser") // login form should POST data to the url (check the username and password)
			.permitAll() // allow every one 
			.and()
			.logout().permitAll() // add logout support for default URL /logout.
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied"); // handle the backdoor access using url without the authorization Role(s).
	}
	
}
