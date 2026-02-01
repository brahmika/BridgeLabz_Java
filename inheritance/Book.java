/*
 Library Management System
 This program demonstrates single inheritance
 where Author extends Book.
*/

public class Book {

    // Title of the book
    String title;

    // Year the book was published
    int publicationYear;

    // Constructor to initialize book details
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Displays basic book information
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}
// Author class inherits from Book
class Author extends Book {

    // Name of the author
    String name;

    // Short biography of the author
    String bio;

    // Constructor to initialize Author and Book details
    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    // Displays book and author information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}
// Library class contains the main method
class Library {

    // Program execution starts here
    public static void main(String[] args) {

        // Creating Author object using Book reference
        Book book = new Author(
                "Clean Code",
                2008,
                "Robert C. Martin",
                "Software engineer and author"
        );

        // Polymorphic call to displayInfo method
        book.displayInfo();
    }
}
