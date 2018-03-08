package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read Spring config file.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from the Spring Container.
		Coach coach = context.getBean("tennisCoach", Coach.class);
		Coach jonathanCoach = context.getBean("jperezCoach", Coach.class);
		
		// call a method on the bean.
		System.out.println(coach.getDailyWorkout());
		System.out.println(jonathanCoach.getDailyFortune());
		
		// call method get daily fortune
		System.out.println(coach.getDailyFortune());
		System.out.println(jonathanCoach.getDailyFortune());
		
		// close the container.
		context.close();
		

	}

}
