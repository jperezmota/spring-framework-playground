package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger.
	Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup point cut declaration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling.
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===>> in @Before: calling method: " + theMethod);
		
		// display the arguments to the method
		Object[] args = theJoinPoint.getArgs();
		
		// loop through and display the arguments
		for(Object tempArg: args) {
			myLogger.info("=====>> argument: " + tempArg);
		}
	}
	
	
	// add @AfterReturning advice

}
