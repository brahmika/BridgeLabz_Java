/*
 Problem 1: Library and Books (Aggregation)

 This program demonstrates aggregation.
 A Library can have multiple Book objects, but a Book
 can exist independently of a Library.
*/

import java.util.ArrayList;

// Book class (independent entity)
class Book {

    String title;
    String author;

    // Constructor to initialize book details
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to display book information
    void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

// Library class (aggregates Book objects)
public class Library {

    // ArrayList to store books
    ArrayList<Book> books = new ArrayList<>();

    // Method to add a book to the library
    void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books in the library
    void displayLibraryBooks() {
        for (Book book : books) {
            book.displayBook();
        }
    }

    public static void main(String[] args) {

        // Creating Book objects (exist independently)
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("The Alchemist", "Paulo Coelho");

        // Creating first library
        Library library1 = new Library();
        library1.addBook(book1);
        library1.addBook(book2);

        // Creating second library.
        Library library2 = new Library();
        library2.addBook(book1); // Same book added to another library

        // Displaying books in library1
        System.out.println("Library 1 Books:");
        library1.displayLibraryBooks();

        // Displaying books in library2
        System.out.println("\nLibrary 2 Books:");
        library2.displayLibraryBooks();
    }
}
