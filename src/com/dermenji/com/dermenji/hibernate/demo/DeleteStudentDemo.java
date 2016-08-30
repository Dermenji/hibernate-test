package com.dermenji.com.dermenji.hibernate.demo;

import com.dermenji.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by fns02 on 8/24/2016.
 */
public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentID = 0;

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting student with ID: " + studentID);

            Student myStudent = session.get(Student.class, studentID);

            session.delete(myStudent);

            //new

            session.createQuery("delete from Student where id = '2'").executeUpdate();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
