package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create pointcut for package and getter/setter
	@Pointcut("forDaoPackage() %% !(getter() || setter())")
	public void forDaoPackageNoGetterAndSetter() {}
	
	// Before advice
	@Before("forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvise() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analalytics");
	}
}
