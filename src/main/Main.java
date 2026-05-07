package main;
import model.Book;
import service.LibraryService;

public class Main {
    public static void main(String[] args){

        //Create library service
        LibraryService library = new LibraryService();

        //Create Books
        Book book1 = new Book(1, "Java Basics", "John Doe");
        Book book2 = new Book(2, "Clean Code", "Robert Martin");

        //Add Books
        library.addBook(book1);
        library.addBook(book2);

        //View Books
        System.out.println("\nLibrary Books:");
        library.viewBooks();

    }
}
