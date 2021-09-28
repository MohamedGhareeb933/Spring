
package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
}
 