package com.samip.onetoone.uni.main;

import com.samip.onetoone.uni.entity.Instructor;
import com.samip.onetoone.uni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteRecord {
    public static void main(String[] args) {
        // make a session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate-one-one-uni.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // make a session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            //get the instructor by id
            //delete that id instrcutor
            int theId=2;
            Instructor instructor = session.get(Instructor.class, theId);

            if(instructor != null) {
                System.out.println("Instrcuotr found: "+instructor);

                //NOTE: Instructor details also will be delted cause of CASCADE.ALL
                session.delete(instructor);
            }

            // commit transaction
            session.getTransaction().commit();

            System.out.println("We r Done");
        } finally {
            factory.close();
        }
    }

}
