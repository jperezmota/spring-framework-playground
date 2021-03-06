package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExc) {
		// print out which method we are advising
		String theMethod = joinPoint.getSignature().toShortString();
		System.out.println("\n\n=====>>> Executing @AfterThrowing on method: " + theMethod);
		
		// log the exception
		System.out.println("\n\n=====>>> The exception is: " + theExc);
		
	}
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out wich method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n=====>>> Result is: " + result);
		
		// lets post-proccess the data. Lets modify it.
		
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n=====>>> Result is: " + result);
		
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
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object tempArgs: args) {
			System.out.println(tempArgs);
			
			if(tempArgs instanceof Account) {
				
				// downcast and prints Account specific stuff
				Account theAccount = (Account)tempArgs;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
		
		
	}
	
	

}
