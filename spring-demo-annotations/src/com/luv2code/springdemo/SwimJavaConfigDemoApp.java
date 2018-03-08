package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read Spring config java class.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean from the Spring Container.
		//Coach coach = context.getBean("swimCoach", Coach.class);
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		
		// call a method on the bean.
		System.out.println(coach.getDailyWorkout());
	
		// call method get daily fortune
		System.out.println(coach.getDailyFortune());
		
		// call our new swim coach methods... Has the props values injected
		System.out.println("Email: " + coach.getEmail());
		System.out.println("Team: " + coach.getTeam());
		
		
		// close the container.
		context.close();
		

	}

}
