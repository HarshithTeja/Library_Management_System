package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        while(true){

            System.out.println("\n===== Library Management System =====");

            System.out.println("1 Add Book");
            System.out.println("2 View Books");
            System.out.println("3 Delete Book");
            System.out.println("4 Update Book Quantity");
            System.out.println("5 Add Student");
            System.out.println("6 View Students");
            System.out.println("7 Issue Book");
            System.out.println("8 Return Book");
            System.out.println("9 Exit");

            int choice=sc.nextInt();

            switch(choice){

                case 1:

                    sc.nextLine();
                    System.out.println("Enter Title:");
                    String title=sc.nextLine();

                    System.out.println("Enter Author:");
                    String author=sc.nextLine();

                    System.out.println("Enter Quantity:");
                    int quantity=sc.nextInt();

                    org.example.BookDAO.addBook(title,author,quantity);

                    break;

                case 2:

                    org.example.BookDAO.viewBooks();
                    break;

                case 3:

                    System.out.println("Enter Book ID:");
                    int id=sc.nextInt();

                    org.example.BookDAO.deleteBook(id);
                    break;

                case 4:

                    System.out.println("Enter Book ID:");
                    int bid=sc.nextInt();

                    System.out.println("Enter New Quantity:");
                    int qty=sc.nextInt();

                    org.example.BookDAO.updateBook(bid,qty);
                    break;

                case 5:

                    sc.nextLine();
                    System.out.println("Enter Student Name:");
                    String name=sc.nextLine();

                    System.out.println("Enter Course:");
                    String course=sc.nextLine();

                    StudentDAO.addStudent(name,course);
                    break;

                case 6:

                    StudentDAO.viewStudents();
                    break;

                case 7:

                    System.out.println("Enter Student ID:");
                    int sid=sc.nextInt();

                    System.out.println("Enter Book ID:");
                    int bookId=sc.nextInt();

                    IssueDAO.issueBook(sid,bookId);
                    break;

                case 8:

                    System.out.println("Enter Issue ID:");
                    int issueId=sc.nextInt();

                    IssueDAO.returnBook(issueId);
                    break;

                case 9:

                    System.exit(0);

            }

        }

    }

}