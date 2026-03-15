package org.example;

import java.sql.*;
public  class DBConnection{
    static Connection con ;
    public static Connection getConnection(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","teja8816");
        } catch (SQLException e) {
            System.out.println("connection failed");
            throw new RuntimeException(e);
        }
        return con;
    }
}