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
