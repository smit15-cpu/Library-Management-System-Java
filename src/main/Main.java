package main;
import model.Book;
import service.LibraryService;
import database.DBConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        LibraryService library = new LibraryService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.println("6. Search Book");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // important fix

            switch (choice) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine().trim();

                    System.out.print("Enter author: ");
                    String author = sc.nextLine().trim();

                    if (title.isEmpty() || author.isEmpty()) {
                        System.out.println("Title and Author cannot be empty!");
                        break;
                    }


                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;

                case 4:
                    System.out.print("Enter book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 5:
                    System.out.println("Exiting... Bye!");
                    System.exit(0);

                case 6:
                    System.out.print("Enter book ID to search: ");
                    int searchId = sc.nextInt();
                    library.searchBook(searchId);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
