import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String ISBN;
    private String title;
    private String author;
    private boolean available;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        return ISBN + " - " + title + " by " + author;
    }
}

class Patron {
    private String ID;
    private String name;

    public Patron(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return ID + " - " + name;
    }
}

class Transaction {
    private String transactionID;
    private String date;
    private Book book;
    private Patron patron;

    public Transaction(String transactionID, String date, Book book, Patron patron) {
        this.transactionID = transactionID;
        this.date = date;
        this.book = book;
        this.patron = patron;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getDate() {
        return date;
    }

    public Book getBook() {
        return book;
    }

    public Patron getPatron() {
        return patron;
    }

    public String toString() {
        String action = (patron != null) ? "Lent" : "Returned";
        return "Transaction ID: " + transactionID +
                " - Date: " + date +
                " - Action: " + action +
                " - Book: " + book.getTitle() +
                " - Patron: " + ((patron != null) ? patron.getName() : "N/A");
    }
}

class Library {
    private Map<String, Book> books;
    private Map<String, Patron> patrons;
    private ArrayList<Transaction> transactions;
    private int transactionCounter;

    public Library() {
        books = new HashMap<>();
        patrons = new HashMap<>();
        transactions = new ArrayList<>();
        transactionCounter = 1;
        initializeLibrary();
    }

    private void initializeLibrary() {
        books.put("001", new Book("001", "The Catcher in the Rye", "J.D. Salinger"));
        books.put("002", new Book("002", "To Kill a Mockingbird", "Harper Lee"));

        patrons.put("1001", new Patron("1001", "John Doe"));
        patrons.put("1002", new Patron("1002", "Jane Smith"));
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        books.values().stream()
                .filter(Book::isAvailable)
                .forEach(book -> System.out.println(book));
        System.out.println();
    }

    public void displayPatrons() {
        System.out.println("Patrons:");
        patrons.values().forEach(patron -> System.out.println(patron));
        System.out.println();
    }

    public void lendBook(String patronID, String bookISBN, String date) {
        Book book = books.get(bookISBN);
        Patron patron = patrons.get(patronID);

        if (book != null && patron != null && book.isAvailable()) {
            book.setAvailable(false);
            transactions.add(new Transaction(generateTransactionID(), date, book, patron));
            System.out.println("Book lent successfully!");
        } else {
            System.out.println("Invalid book or patron ID, or the book is not available.");
        }
    }

    public void returnBook(String bookISBN, String date) {
        Book book = books.get(bookISBN);

        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book returned successfully!");
            transactions.add(new Transaction(generateTransactionID(), date, book, null));
        } else {
            System.out.println("Invalid book ISBN or the book is already available.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        transactions.forEach(transaction -> System.out.println(transaction));
        System.out.println();
    }

    public void addBook(String ISBN, String title, String author) {
        if (!books.containsKey(ISBN)) {
            books.put(ISBN, new Book(ISBN, title, author));
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Book with ISBN " + ISBN + " already exists.");
        }
    }

    public void addPatron(String ID, String name) {
        if (!patrons.containsKey(ID)) {
            patrons.put(ID, new Patron(ID, name));
            System.out.println("Patron added successfully!");
        } else {
            System.out.println("Patron with ID " + ID + " already exists.");
        }
    }

    private String generateTransactionID() {
        return "T" + transactionCounter++;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    library.displayPatrons();
                    break;
                case 3:
                    lendBook(library, scanner);
                    break;
                case 4:
                    returnBook(library, scanner);
                    break;
                case 5:
                    library.displayTransactionHistory();
                    break;
                case 6:
                    addBook(library, scanner);
                    break;
                case 7:
                    addPatron(library, scanner);
                    break;
                case 8:
                    exitSystem(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Display Available Books");
        System.out.println("2. Display Patrons");
        System.out.println("3. Lend Book");
        System.out.println("4. Return Book");
        System.out.println("5. Display Transaction History");
        System.out.println("6. Add Book");
        System.out.println("7. Add Patron");
        System.out.println("8. Exit");
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
            System.out.print("Enter your choice: ");
        }
        return scanner.nextInt();
    }

    private static void lendBook(Library library, Scanner scanner) {
        System.out.print("Enter Patron ID: ");
        String lendPatronID = scanner.next();
        System.out.print("Enter Book ISBN: ");
        String lendBookISBN = scanner.next();
        System.out.print("Enter Date: ");
        String lendDate = scanner.next();
        library.lendBook(lendPatronID, lendBookISBN, lendDate);
    }

    private static void returnBook(Library library, Scanner scanner) {
        System.out.print("Enter Book ISBN: ");
        String returnBookISBN = scanner.next();
        System.out.print("Enter Date: ");
        String returnDate = scanner.next();
        library.returnBook(returnBookISBN, returnDate);
    }

    private static void addBook(Library library, Scanner scanner) {
        System.out.print("Enter Book ISBN: ");
        String ISBN = scanner.next();
        System.out.print("Enter Book Title: ");
        String title = scanner.next();
        System.out.print("Enter Author: ");
        String author = scanner.next();

        library.addBook(ISBN, title, author);
    }

    private static void addPatron(Library library, Scanner scanner) {
        System.out.print("Enter Patron ID: ");
        String ID = scanner.next();
        System.out.print("Enter Patron Name: ");
        String name = scanner.next();

        library.addPatron(ID, name);
    }

    private static void exitSystem(Scanner scanner) {
        System.out.println("Exiting the Library Management System. Goodbye!");
        scanner.close();
        System.exit(0);
    }
}
