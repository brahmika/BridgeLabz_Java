//This class checks for the products and calculates the total products.
public class Product {

    String productName;
    double price;
    static int totalProducts = 0;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        Product.totalProducts++;
    }
    //method to display products
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    //method to calculate total amount products
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        System.out.println("MAIN STARTED");

        Product product1 = new Product("Book", 500);
        Product product2 = new Product("Pen", 20);
        Product product3 = new Product("Chips", 30);

        product1.displayProductDetails();
        product2.displayProductDetails();
        product3.displayProductDetails();

        Product.displayTotalProducts();
    }
}
