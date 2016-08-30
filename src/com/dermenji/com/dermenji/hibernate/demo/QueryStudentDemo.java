package com.dermenji.com.dermenji.hibernate.demo;

import com.dermenji.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by fns02 on 8/24/2016.
 */
public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName = 'Dermenji' ").getResultList();

            displayStudents(theStudents);


            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student theStudent : theStudents){
            System.out.println(theStudent);
        }
    }
}