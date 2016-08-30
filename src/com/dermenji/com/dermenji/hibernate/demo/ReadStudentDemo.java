package com.dermenji.com.dermenji.hibernate.demo;

import com.dermenji.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by fns02 on 8/24/2016.
 */
public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("uygtf", "Derlkjkjmenji", "nbhv.dermenji@gmail.com");

            session.beginTransaction();
            System.out.println(student);
            session.save(student);

            session.getTransaction().commit();
            System.out.println("Generated id: " + student.getId());


            session = factory.getCurrentSession();

            session.beginTransaction();

            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("det complete : " + myStudent);
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
