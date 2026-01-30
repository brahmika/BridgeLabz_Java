//This library class keeps the track of the title of the book, the author and price along with the availability of the book.
public class Library{
    String title;
    String author;
    double price;
    boolean availability;

    //setting up parameterised constructor
    public Library(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true;
    }
    public void borrowBook(){
        if(availability){
            availability = false;
            System.out.println("You have successfully borrowed: " + title);
        }else{
            System.out.println("The book " + "isn't currently available.");
        }
    }
    public void returnBook(){
        availability = true;
        System.out.println("You have successfully retured: " + title);
    }
    public void displayDetails(){
        System.out.println(title);
        System.out.println(author);
        System.out.println(price);
        System.out.println(availability ? "Yes" : "No");

    }
    public static void main(String[] args){
        Library book1 = new Library("Matilda", "Roald Dahl", 150);
        book1.borrowBook();
        book1.borrowBook();
        book1.returnBook();
        book1.borrowBook();
    }
}