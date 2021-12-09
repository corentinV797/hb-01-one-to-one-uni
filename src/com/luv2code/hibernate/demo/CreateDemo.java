package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			/*Instructor tempInstructor =
					new Instructor("Chad", "Darby", "darby@luv2code.com");
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.luv2code.com/youtube",
							"Luv 2 code!!!");
			
			tempInstructor.setInstructionDetail(tempInstructorDetail);*/
			Instructor tempInstructor =
					new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.youtube.com",
							"Guitar");
			
			tempInstructor.setInstructionDetail(tempInstructorDetail);
					
			session.beginTransaction();

			// also save details because of CascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
