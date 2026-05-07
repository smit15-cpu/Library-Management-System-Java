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
        System.out.println("\nAll Books:");
        library.viewBooks();

        System.out.println("\nIssuing Book ID 1:");
        library.issueBook(1);

        System.out.println("\nBooks After Issuing:");
        library.viewBooks();

        System.out.println("\nReturning Book ID 1:");
        library.returnBook(1);

        System.out.println("\nFinal Library Status:");
        library.viewBooks();

    }
}
