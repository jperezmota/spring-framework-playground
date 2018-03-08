package com.luv32code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create student object
			System.out.println("Creating new student object...");
			Student theStudent = new Student("Julissa", "Almonte", "julissaalmonte@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student object...");
			System.out.println(theStudent);
			session.save(theStudent);	
			
			// commit transaction
			session.getTransaction().commit();
			
			
			
			
			// MY NEW CODE
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + theStudent.getId());
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + theStudent.getId());
			Student myStudent = session.get(Student.class, theStudent.getId());
			System.out.println("Get complete: " + myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}catch(Exception exc) {
			factory.close();
		}
	}

}
