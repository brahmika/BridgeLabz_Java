// Shopping Cart System: This program demonstrates a Product class with static variable and method, final variable for productID, 'this' keyword in constructor, and instanceof operator

public class Product {

    // Static variable shared by all products
    static double discount = 10.0; // 10% default discount

    // Final variable: cannot be changed once assigned
    final int productID;

    // Instance variables
    String productName;
    double price;
    int quantity;

    // Constructor using 'this' to resolve ambiguity
    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName; // resolves ambiguity
        this.price = price;             // resolves ambiguity
        this.quantity = quantity;       // resolves ambiguity
        this.productID = productID;     // final variable
    }

    // Static method to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    // Method to display product details
    public void displayProductDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
    }
}

// Subclass with main method
class ShoppingCartDemo extends Product {

    public ShoppingCartDemo(String productName, double price, int quantity, int productID) {
        super(productName, price, quantity, productID);
    }

    public static void main(String[] args) {

        // Create product objects
        ShoppingCartDemo p1 = new ShoppingCartDemo("Laptop", 50000, 1, 101);
        ShoppingCartDemo p2 = new ShoppingCartDemo("Headphones", 2000, 2, 102);

        // instanceof check before displaying details
        if (p1 instanceof Product) p1.displayProductDetails();
        if (p2 instanceof Product) p2.displayProductDetails();

        // Update discount using static method
        Product.updateDiscount(15.0);

        // Display product details again after discount change
        if (p1 instanceof Product) p1.displayProductDetails();
        if (p2 instanceof Product) p2.displayProductDetails();
    }
}
