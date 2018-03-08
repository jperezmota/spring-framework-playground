package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load  spring configuration file.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from the container
		Coach coach = context.getBean("myCoach", Coach.class);
		
		// class methods on the bean
		System.out.println(coach.getDailyWorkout());
		
		// let's call out new method for fortunes.
		System.out.println(coach.getDailyFortune());
		
		// Close the context.
		context.close();

	}

}
