package com.mohamed.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class MyDemoAnalyticsAspect {

	@Before("com.mohamed.aopdemo.aspect.AOPExpression.ApplyNoGetterSetter()")
	public void addAccount() {
		System.out.println("@Before Add Account");
	}
	
}
