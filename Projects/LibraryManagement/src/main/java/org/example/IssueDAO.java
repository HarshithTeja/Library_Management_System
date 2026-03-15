package org.example;

import org.example.DBConnection;

import java.sql.*;

public class IssueDAO {

    public static void issueBook(int studentId,int bookId){

        try{

            Connection con= DBConnection.getConnection();

            String query="INSERT INTO issue_book(student_id,book_id,issue_date) VALUES(?,?,CURDATE())";

            PreparedStatement ps=con.prepareStatement(query);

            ps.setInt(1,studentId);
            ps.setInt(2,bookId);

            ps.executeUpdate();

            System.out.println("Book Issued Successfully");

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void returnBook(int issueId){

        try{

            Connection con= DBConnection.getConnection();

            String query="UPDATE issue_book SET return_date=CURDATE() WHERE issue_id=?";

            PreparedStatement ps=con.prepareStatement(query);

            ps.setInt(1,issueId);

            ps.executeUpdate();

            System.out.println("Book Returned Successfully");

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}