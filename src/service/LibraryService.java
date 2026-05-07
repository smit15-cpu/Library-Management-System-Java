package service;
import database.DBConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LibraryService {

    //ArrayList to store books
    private ArrayList<Book> books = new ArrayList<>();

    //Add Books
    public void addBook(Book book) {

        Connection conn = DBConnection.getConnection();

        if (conn == null) {
            System.out.println("No DB connection");
            return;
        }

        String query = "INSERT INTO books (title, author, isIssued) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setBoolean(3, book.isIssued());

            ps.executeUpdate();

            System.out.println("Book added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //View all books
    public void viewBooks() {
        String query = "SELECT * FROM books";

        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)){

            System.out.println("\n Library Books:");

            while (rs.next()){

                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                boolean isIssued = rs.getBoolean("isIssued");

                System.out.println(
                        "ID: " + id +
                        ", Title: " + title +
                        ", Author: " + author +
                        ", Issued: " + isIssued
                );
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Search book by ID
    public Book searchBookById(int id){

        for(Book book : books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    // Issue Book
    public void issueBook(int id){

        Book book = searchBookById(id);

        if(book == null){
            System.out.println("Book not found");
            return;
        }

        if(book.isIssued()){
            System.out.println("Book is already issued.");
        }else {
            book.setIssued(true);
            System.out.println(book.getTitle() + " issued successfully.");
        }
    }

    //Return Book
    public void returnBook(int id){
        Book book = searchBookById(id);

        if(book == null){
            System.out.println("Book not found.");
            return;
        }

        if(!book.isIssued()){
            System.out.println("Book was not issued.");
        }else {
            book.setIssued(false);
            System.out.print(book.getTitle() + "returned successfully");
        }
    }
}
