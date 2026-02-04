/*
 * :This program demonstrates core Object-Oriented Programming concepts in Java:
 * - Abstraction using an abstract Product class
 * - Inheritance through Electronics, Clothing, and Groceries classes
 * - Encapsulation by protecting product details with private fields
 * - Interface implementation using Taxable for tax-related behavior
 * - Polymorphism by processing different product types using Product references
 */

import java.util.ArrayList;

// Interface for tax-related operations
interface Taxable {

    // Calculates tax for a product
    double calculateTax();

    // Returns tax information
    String getTaxDetails();
}

// Abstract class representing a generic product
abstract class Product {

    // Encapsulated product details
    private int productId;
    private String name;
    private double price;

    // Constructor to initialize product details
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method for calculating discount
    public abstract double calculateDiscount();

    // Returns product ID
    public int getProductId() {
        return productId;
    }

    // Returns product name
    public String getName() {
        return name;
    }

    // Returns product price
    public double getPrice() {
        return price;
    }

    // Updates price with validation
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }
}

// Electronics product with tax implementation
class Electronics extends Product implements Taxable {

    // Constructor for electronics product
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    // Calculates discount for electronics
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    // Calculates tax for electronics
    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    // Returns tax details for electronics
    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

// Clothing product with tax implementation
class Clothing extends Product implements Taxable {

    // Constructor for clothing product
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    // Calculates discount for clothing
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    // Calculates tax for clothing
    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    // Returns tax details for clothing
    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5%";
    }
}

// Groceries product without tax
class Groceries extends Product {

    // Constructor for groceries product
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    // Calculates discount for groceries
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main application class
public class ECommerceApp {

    // Calculates and prints final prices using polymorphism
    public static void printFinalPrices(ArrayList<Product> products) {

        // Loop through products list
        for (Product p : products) {
            double tax = 0;

            // Check if product is taxable
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
            }

            // Calculate discount
            double discount = p.calculateDiscount();

            // Final price calculation
            double finalPrice = p.getPrice() + tax - discount;

            // Display final price
            System.out.println(
                    p.getName() + " | Final Price: " + finalPrice
            );
        }
    }

    // Main method: program execution starts here
    public static void main(String[] args) {

        // Create list of products
        ArrayList<Product> products = new ArrayList<>();

        // Add products to list
        products.add(new Electronics(101, "Laptop", 60000));
        products.add(new Clothing(102, "Jacket", 3000));
        products.add(new Groceries(103, "Rice", 1200));

        // Print final prices
        printFinalPrices(products);
    }
}
