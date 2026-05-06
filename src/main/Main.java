package main;
import model.Book;

public class Main {
    public static void main(String[] args){

        Book book1 = new Book(1, "Java Basics", "John Doe");
        Book book2 = new Book(2, "OOP Concepts", "Jane Smith");

        book1.displayBook();
        book2.displayBook();

    }
}
