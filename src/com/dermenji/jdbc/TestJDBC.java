package com.dermenji.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by fns02 on 8/22/2016.
 */
public class TestJDBC {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";
        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myCon = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection succesful!!!");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
