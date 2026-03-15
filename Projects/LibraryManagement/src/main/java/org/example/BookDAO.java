package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookDAO {

    public static void addBook(String title,String author,int quantity){

        try{

            Connection con = DBConnection.getConnection();

            String query="INSERT INTO books(title,author,quantity) VALUES(?,?,?)";

            PreparedStatement ps=con.prepareStatement(query);

            ps.setString(1,title);
            ps.setString(2,author);
            ps.setInt(3,quantity);

            ps.executeUpdate();

            System.out.println("Book Added Successfully");

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void viewBooks(){

        try{

            Connection con=DBConnection.getConnection();

            String query="SELECT * FROM books";

            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery(query);

            while(rs.next()){

                System.out.println(
                        rs.getInt("book_id")+" "+
                                rs.getString("title")+" "+
                                rs.getString("author")+" "+
                                rs.getInt("quantity")
                );

            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void deleteBook(int id){

        try{

            Connection con = DBConnection.getConnection();

            String query="DELETE FROM books WHERE book_id=?";

            PreparedStatement ps=con.prepareStatement(query);

            ps.setInt(1,id);

            ps.executeUpdate();

            System.out.println("Book Deleted Successfully");

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void updateBook(int id,int quantity){

        try{

            Connection con=DBConnection.getConnection();

            String query="UPDATE books SET quantity=? WHERE book_id=?";

            PreparedStatement ps=con.prepareStatement(query);

            ps.setInt(1,quantity);
            ps.setInt(2,id);

            ps.executeUpdate();

            System.out.println("Book Updated Successfully");

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}