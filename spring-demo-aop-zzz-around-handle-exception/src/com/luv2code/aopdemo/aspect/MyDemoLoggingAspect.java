package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @After (finally) on method:" + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now lets execute the method
		Object result = null;
		
		try {	
			result = theProceedingJoinPoint.proceed();
		}catch(Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			throw e;
		}
		
		
		// get time stamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n=====>>> Duration: " + duration/1000 + " seconds");
		
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising
			String theMethod = theJoinPoint.getSignature().toShortString();
			myLogger.info("\n\n=====>>> Executing @After (Finally) on method: " + theMethod);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExc) {
		// print out which method we are advising
		String theMethod = joinPoint.getSignature().toShortString();
		myLogger.info("\n\n=====>>> Executing @AfterThrowing on method: " + theMethod);
		
		// log the exception
		myLogger.info("\n\n=====>>> The exception is: " + theExc);
		
	}
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out wich method we are advising on
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing AfterReturning on method: " + method);
		
		// print out the results of the method call
		myLogger.info("\n=====>>> Result is: " + result);
		
		// lets post-proccess the data. Lets modify it.
		
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n=====>>> Result is: " + result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		
		for(Account tempAccount: result) {
			// get upper case version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
		}
		
		
	}

	// Before advice
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvise(JoinPoint theJoinPoint) {
		myLogger.info("\n=====>>> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
		myLogger.info("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object tempArgs: args) {
			myLogger.info(tempArgs.toString());
			
			if(tempArgs instanceof Account) {
				
				// downcast and prints Account specific stuff
				Account theAccount = (Account)tempArgs;
				
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
			}
		}
		
		
	}
	
	

}
