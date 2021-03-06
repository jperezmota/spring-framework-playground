package com.luv32code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create student object
			System.out.println("Creating new instructor object...");
			
//			Instructor tempInstructor = new Instructor("Jonathan", "Perez", "jonathanperezmota@gmail.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.expressiveinsight.com/youtube", "Inspire");
			
			Instructor tempInstructor = new Instructor("Lidia", "Bueno", "lbueno@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.charity.com/youtube", "Charity");
			
			// associate the object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start transacction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the detail object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
