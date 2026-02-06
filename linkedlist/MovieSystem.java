/*
Movie Management System using Doubly Linked List.
Each node stores movie details: Title, Director, Year, and Rating.
The program supports insertion, deletion, searching, updating,
and displaying movies in both forward and reverse order.
*/

package linkedlist;

import java.util.Scanner;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;

    MovieNode prev;
    MovieNode next;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieDoublyLinkedList {
    private MovieNode head;
    private MovieNode tail;

    // 1️⃣ Add at Beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // 2️⃣ Add at End
    void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // 3️⃣ Add at Specific Position (1-based index)
    void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // 4️⃣ Remove by Movie Title
    void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {

                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                }
                else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Movie removed: " + title);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found.");
    }

    // 5️⃣ Search by Director
    void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found for director: " + director);
    }

    // 6️⃣ Search by Rating
    void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found with rating: " + rating);
    }

    // 7️⃣ Display Forward
    void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }

        MovieNode temp = head;
        System.out.println("\nMovies (Forward Order):");

        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // 8️⃣ Display Reverse
    void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }

        MovieNode temp = tail;
        System.out.println("\nMovies (Reverse Order):");

        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // 9️⃣ Update Rating by Title
    void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for movie: " + title);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found.");
    }

    // Helper method
    private void displayMovie(MovieNode movie) {
        System.out.println(
                "Title: " + movie.title +
                        ", Director: " + movie.director +
                        ", Year: " + movie.year +
                        ", Rating: " + movie.rating
        );
    }
}

public class MovieSystem {
    public static void main(String[] args) {

        MovieDoublyLinkedList movies = new MovieDoublyLinkedList();

        // Adding movies
        movies.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movies.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movies.addAtEnd("Parasite", "Bong Joon-ho", 2019, 8.5);
        movies.addAtPosition(2, "Dune", "Denis Villeneuve", 2021, 8.3);

        // Display
        movies.displayForward();
        movies.displayReverse();

        // Search
        movies.searchByDirector("Christopher Nolan");
        movies.searchByRating(8.5);

        // Update
        movies.updateRating("Dune", 8.7);

        // Remove
        movies.removeByTitle("Interstellar");

        // Final Display
        movies.displayForward();
    }
}
