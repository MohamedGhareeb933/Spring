package com.mohamed.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	// below code will be running before calling add account method.
	
	//@Before("execution(public void addAccount())") 
	//@Before("execution(public void com.mohamed.aopdemo.dao.AccountDAO.addAccount())") // Class Declaration specified to Account DAO only instead of Wildcard.
	//@Before("execution(public void add*())") // Match Method Starting with Add using * Wildcard
	//@Before("execution(void *())") // Match Method Based on Return Type - spring AOP only use public Access specifier
	//@Before("execution(* add*())") // Match Method Based on any Return Type and method Starting with add
	//@Before("execution(* com.mohamed.aopdemo.dao.*.*(..))") // Match based on Specific Package - .* any Class .* any Method. any param
	//@Before("execution(* com.mohamed.aopdemo.dao.*.add*(com.mohamed.aopdemo.Account))") // Match Based on Account Param.
	@Before("execution(* com.mohamed.aopdemo.dao.*.add*(com.mohamed.aopdemo.Account, ..))") // first Param must be of type Account , any num of Argument follow
	public void beforeAddAccount() {
		System.out.println("Excuting @Before - beforeAddAccount()");
	}
}
