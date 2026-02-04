/*
 * This program demonstrates:
 * - Abstraction using the LibraryItem abstract class
 * - Inheritance through Book, Magazine, and DVD classes
 * - Interface implementation using Reservable
 * - Encapsulation to protect borrower personal data
 * - Polymorphism by managing different items using LibraryItem reference
 */

// Interface for reservation functionality.
interface Reservable {

    // Reserve the library item
    void reserveItem(String borrowerName);

    // Check availability status
    boolean checkAvailability();
}

// Abstract base class for library items
abstract class LibraryItem {

    // Encapsulated fields
    private int itemId;
    private String title;
    private String author;

    // Sensitive borrower information
    private String borrowerName;
    private boolean isAvailable = true;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method to define loan duration
    public abstract int getLoanDuration();

    // Display item details
    public void getItemDetails() {
        System.out.println(
                "ID: " + itemId +
                        " | Title: " + title +
                        " | Author: " + author +
                        " | Loan Days: " + getLoanDuration()
        );
    }

    // Protected method to update borrower info
    protected void assignBorrower(String name) {
        this.borrowerName = name;
        this.isAvailable = false;
    }

    // Protected method to check availability
    protected boolean isAvailable() {
        return isAvailable;
    }
}

// Book class
class Book extends LibraryItem implements Reservable {

    // Constructor
    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    // Loan duration for books
    @Override
    public int getLoanDuration() {
        return 14;
    }

    // Reserve book
    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            assignBorrower(borrowerName);
            System.out.println("Book reserved by " + borrowerName);
        }
    }

    // Check availability
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {

    // Constructor
    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    // Loan duration for magazines
    @Override
    public int getLoanDuration() {
        return 7;
    }

    // Reserve magazine
    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            assignBorrower(borrowerName);
            System.out.println("Magazine reserved by " + borrowerName);
        }
    }

    // Check availability
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {

    // Constructor
    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    // Loan duration for DVDs
    @Override
    public int getLoanDuration() {
        return 3;
    }

    // Reserve DVD
    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            assignBorrower(borrowerName);
            System.out.println("DVD reserved by " + borrowerName);
        }
    }

    // Check availability
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Main class to demonstrate polymorphism
public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Polymorphic array of library items
        LibraryItem[] items = {
                new Book(101, "Java Fundamentals", "James Gosling"),
                new Magazine(102, "Tech Monthly", "Editorial Team"),
                new DVD(103, "Inception", "Christopher Nolan")
        };

        // Iterate through library items
        for (LibraryItem item : items) {

            // Display item details
            item.getItemDetails();

            // Reserve item using interface reference
            Reservable r = (Reservable) item;
            r.reserveItem("Alice");

            // Print availability status
            System.out.println("Available: " + r.checkAvailability());
        }
    }
}
