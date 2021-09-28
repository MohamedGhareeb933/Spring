package com.mohamed.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpression {

	// execute dao methods
	@Pointcut("execution(* com.mohamed.aopdemo.dao.*.*(..))") 
	public void pointcutDAO() { }
	
	// execute dao get method
	@Pointcut("execution(* com.mohamed.aopdemo.dao.*.get*(..))") 
	public void getter() { }
	
	// execute dao get method
	@Pointcut("execution(* com.mohamed.aopdemo.dao.*.set*(..))") 
	public void setter() { }
	
	// execute all dao method except getter() which have the expression of get method and setter methods
	@Pointcut("pointcutDAO() && !(getter() || setter())")
	public void ApplyNoGetterSetter() { }
	
	
}
