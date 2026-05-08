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

    // Issue Book
    public void issueBook(int id){

        String query = "UPDATE books SET isIssued = true WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1,id);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Book issued successfully!");
            } else {
                System.out.println("Book not found!");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Return Book
    public void returnBook(int id) {
        String query = "UPDATE books SET isIssued = false WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Books returned successfully!");
            } else {
                System.out.println("Book not found!");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void searchBook(int id){
        String query = "SELECT * FROM books WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\nBook Found");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Issued: " + rs.getBoolean("isIssued"));
            } else {
                System.out.println("Book not found!");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
