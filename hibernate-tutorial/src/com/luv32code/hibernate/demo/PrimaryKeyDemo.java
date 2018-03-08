package com.luv32code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
			
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 student object
			System.out.println("Creating new student object...");
			Student tempStudent1 = new Student("Lidia", "Bueno", "lidiabueno@gmail.com");
			Student tempStudent2 = new Student("Luis", "Sosa", "luissosa@gmail.com");
			Student tempStudent3 = new Student("Altagracia", "Mota", "altagraciamota@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student object...");
			session.save(tempStudent1);	
			session.save(tempStudent2);	
			session.save(tempStudent3);	
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}catch(Exception exc) {
			factory.close();
		}

	}

}
