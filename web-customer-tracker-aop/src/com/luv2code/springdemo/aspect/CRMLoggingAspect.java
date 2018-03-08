package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger.
	Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup point cut declaration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*.(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*.(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*.(..))")
	public void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow() {}
	
	
	// add @Before advice
	
	// add @AfterReturning advice

}
