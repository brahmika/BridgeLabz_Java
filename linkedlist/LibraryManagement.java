package linkedlist;

/*
Library Management System using Doubly Linked List.
Each node represents a book with Book ID, Title, Author,
Genre, and Availability Status.
The system supports adding, removing, searching, updating,
displaying books in forward and reverse order, and counting
the total number of books in the library.
*/

class BookNode {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;

    BookNode prev;
    BookNode next;

    BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.prev = null;
        this.next = null;
    }
}

class LibraryDoublyLinkedList {
    private BookNode head;
    private BookNode tail;

    // Add book at the beginning
    void addAtBeginning(int id, String title, String author, String genre, boolean available) {
        BookNode newNode = new BookNode(id, title, author, genre, available);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add book at the end
    void addAtEnd(int id, String title, String author, String genre, boolean available) {
        BookNode newNode = new BookNode(id, title, author, genre, available);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Add book at a specific position (1-based index)
    void addAtPosition(int pos, int id, String title, String author, String genre, boolean available) {
        if (pos <= 1) {
            addAtBeginning(id, title, author, genre, available);
            return;
        }

        BookNode temp = head;
        int count = 1;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(id, title, author, genre, available);
            return;
        }

        BookNode newNode = new BookNode(id, title, author, genre, available);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Remove a book using Book ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {

                if (temp == head) {
                    head = head.next;
                    if (head != null)
                        head.prev = null;
                    else
                        tail = null;
                }
                else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Book removed successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.");
    }

    // Search for a book by title
    void searchByTitle(String title) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found.");
    }

    // Search for books by author
    void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No books found for this author.");
    }

    // Update availability status using Book ID
    void updateAvailability(int id, boolean status) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability status updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.");
    }

    // Display all books in forward order
    void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode temp = head;
        System.out.println("\nBooks in Forward Order:");

        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode temp = tail;
        System.out.println("\nBooks in Reverse Order:");

        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // Count total number of books
    void countBooks() {
        int count = 0;
        BookNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total number of books: " + count);
    }

    // Helper method to display a single book
    private void displayBook(BookNode book) {
        System.out.println(
                "ID: " + book.bookId +
                        ", Title: " + book.title +
                        ", Author: " + book.author +
                        ", Genre: " + book.genre +
                        ", Available: " + (book.isAvailable ? "Yes" : "No")
        );
    }
}

public class LibraryManagement {
    public static void main(String[] args) {

        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

        library.addAtEnd(101, "1984", "George Orwell", "Dystopian", true);
        library.addAtEnd(102, "The Hobbit", "J.R.R. Tolkien", "Fantasy", true);
        library.addAtBeginning(103, "Clean Code", "Robert C. Martin", "Programming", false);
        library.addAtPosition(2, 104, "Atomic Habits", "James Clear", "Self-Help", true);

        library.displayForward();
        library.displayReverse();

        library.searchByTitle("1984");
        library.searchByAuthor("George Orwell");

        library.updateAvailability(103, true);

        library.removeById(102);

        library.countBooks();
        library.displayForward();
    }
}

