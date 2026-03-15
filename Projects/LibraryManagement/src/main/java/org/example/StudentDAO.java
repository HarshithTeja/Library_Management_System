package org.example;

import java.sql.*;

public class StudentDAO {

    public static void addStudent(String name,String course){

        try{

            Connection con=DBConnection.getConnection();

            String query="INSERT INTO students(name,course) VALUES(?,?)";

            PreparedStatement ps=con.prepareStatement(query);

            ps.setString(1,name);
            ps.setString(2,course);

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void viewStudents(){

        try{

            Connection con=DBConnection.getConnection();

            String query="SELECT * FROM students";

            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery(query);

            while(rs.next()){

                System.out.println(
                        rs.getInt("student_id")+" "+
                                rs.getString("name")+" "+
                                rs.getString("course")
                );

            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}