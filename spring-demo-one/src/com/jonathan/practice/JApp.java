package com.jonathan.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jonathan.practice.repository.DataAccess;
import com.jonathan.practice.services.LogicService;

public class JApp {

	public static void main(String[] args) {
		
		// Getting the ApplicationContext/Spring Container and getting one bean.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataAccess dataAccess = context.getBean("myDataAccess", DataAccess.class);
		System.out.println(dataAccess.getEmployees());
		System.out.println(dataAccess.deleteEmployee(1));
		// 
		
		// Using Dependency Injection
		LogicService logicService = context.getBean("myLogicService", LogicService.class);
		System.out.println(logicService.listEmployees());
		//
		
		context.close();
		

	}

}
