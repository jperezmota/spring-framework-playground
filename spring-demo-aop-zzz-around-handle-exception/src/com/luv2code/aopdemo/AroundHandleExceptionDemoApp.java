package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read Spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from the spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain program: AroundDemoApp");
		
		myLogger.info("\nCalling getFortune()");
		
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finish");
		
		// close the context
		context.close();

	}

}
