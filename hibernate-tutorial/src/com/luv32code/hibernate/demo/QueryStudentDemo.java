package com.luv32code.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
		
			// start a transaction
			session.beginTransaction();
			
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
							
			// display the students
			displayStudents(theStudents);
			
			
							
			// query students: lastName = "mota"
			theStudents = session.createQuery("from Student s where s.lastName = 'mota'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Mota");
			displayStudents(theStudents);
			
			
			
			// query students: lastName='Bueno' OR firName = 'Luis'
			theStudents = session.createQuery("from Student s where s.lastName = 'Bueno' OR s.firstName = 'Luis'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Bueno OR fir name Luis ");
			displayStudents(theStudents);
			
			
			
			// query students where email like '%bueno'
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			//display students
			System.out.println("\n\nStudents whose email ends with gmail.com");
			displayStudents(theStudents);
						
						
						
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}catch(Exception exc) {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
