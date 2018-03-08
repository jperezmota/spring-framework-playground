package com.luv32code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			// get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();		
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			// delete the student
			//System.out.println("Deleting student: " + myStudent);
			//session.delete(myStudent);
	
			// delete student with id =2 
			System.out.println("Deleting student with id = 2") ;
			session.createQuery("delete from Student s where s.id = 2").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!!");
		}catch(Exception exc) {
			factory.close();
		}
	}

}
