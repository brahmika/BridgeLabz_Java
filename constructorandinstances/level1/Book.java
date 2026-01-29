/* Book class with default and parameterized constructors to initialize book details
 */
public class Book{
    String title;
    String author;
    double price;

    public Book(){
        this.title = "Harry Potter";
        this.author = "J.K Rowling";
        this.price = 3000;
    }
    public Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void displayBook(){
        System.out.println(title);
        System.out.println(author);
        System.out.println(price);
    }
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.displayBook();

        System.out.println();

        Book book2 = new Book("Matilda", "Roald Dahl", 235.45);
        book2.displayBook();
    }
}