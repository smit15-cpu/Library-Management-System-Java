package service;
import model.Book;
import java.util.ArrayList;

public class LibraryService {

    //ArrayList to store books
    private ArrayList<Book> books = new ArrayList<>();

    //Add Books
    public void addBook(Book book){
        books.add(book);
        System.out.println(book.getTitle() + "added successfully.");
    }

    //View all books
    public void viewBooks() {
        if(books.isEmpty()){
            System.out.println("No books available.");
            return;
        }

        for (Book book : books){
            book.displayBook();
        }
    }
}
