package com.samip.onetoone.bi.main;

import com.samip.onetoone.bi.entity.Instructor;
import com.samip.onetoone.bi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        // make a session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // make a session
        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("Sarat", "Rai","samip@gmail.com");
            InstructorDetail isnDet = new InstructorDetail("http://yoyube.com/luv", "Foottbal");

            //assocaiate a objects
            instructor.setInstructorDetail(isnDet);

            // start a transaction
            session.beginTransaction();

            //save the instructor
            //NOTE: This also save instructor detail CAUSE of CASCADE.ALL
            System.out.println("Saving Instructor: "+instructor);
            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("We r Done");
        } finally {
            factory.close();
        }

    }
}
