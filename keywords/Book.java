// Library Management System: This program demonstrates a Book class for managing library books with static variable and method, final variable for ISBN, 'this' keyword in constructor, and instanceof operator

public class Book {

    // Static variable shared across all books
    static String libraryName = "City Library";

    // Final variable: cannot be changed once assigned
    final String isbn;

    // Instance variables
    String title;
    String author;

    // Constructor using 'this' to resolve ambiguity
    public Book(String title, String author, String isbn) {
        this.title = title;   // resolves ambiguity
        this.author = author; // resolves ambiguity
        this.isbn = isbn;     // final variable
    }

    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
}

// Subclass with main method
class LibraryDemo extends Book {

    public LibraryDemo(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    public static void main(String[] args) {

        // Create book objects
        LibraryDemo book1 = new LibraryDemo("Effective Java", "Joshua Bloch", "978-0134685991");
        LibraryDemo book2 = new LibraryDemo("Clean Code", "Robert C. Martin", "978-0132350884");

        // instanceof check before displaying
        if (book1 instanceof Book) book1.displayBookDetails();
        if (book2 instanceof Book) book2.displayBookDetails();

        // Display library name using static method
        Book.displayLibraryName();
    }
}
