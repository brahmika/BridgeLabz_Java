/*
   This program demonstrates access modifiers in Java.
   BookLibrary uses public, protected, and private members.
   EBook is a subclass that accesses public and protected members
   and accesses private members using getter methods.
*/

public class BookLibrary {

    public String ISBN;        // public
    protected String title;    // protected
    private String author;     // private

    public BookLibrary(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Setter for private variable
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for private variable
    public String getAuthor() {
        return author;
    }
}

class EBook extends BookLibrary {

    String fileFormat;

    public EBook(String ISBN, String title, String author, String fileFormat) {
        super(ISBN, title, author);
        this.fileFormat = fileFormat;
    }

    public void displayEBookDetails() {
        System.out.println("ISBN: " + ISBN);        // public
        System.out.println("Title: " + title);      // protected
        System.out.println("Author: " + getAuthor()); // private via getter
        System.out.println("Format: " + fileFormat);
    }

    public static void main(String[] args) {
        EBook ebook = new EBook(
                "978-0134685991",
                "Effective Java",
                "Joshua Bloch",
                "PDF"
        );

        ebook.displayEBookDetails();
    }
}
