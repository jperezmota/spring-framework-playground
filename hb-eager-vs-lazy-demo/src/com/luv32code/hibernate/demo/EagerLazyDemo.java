package com.luv32code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class EagerLazyDemo {

public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			// get the instructor from the db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("luv2code: Instructor " + tempInstructor);
			
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("\nluv2code: The session is now closed! \n");
			
			//since the courses are lazy loaded... this should fail.ß
			// get courses for the instructor
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			System.out.println("luv2code: Done!!");
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
