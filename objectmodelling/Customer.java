/*
 This program demonstrates aggregation and communication.
 - Customers place Orders
 - Each Order contains multiple Products
 - Shows interaction between Customer and Order, and aggregation of Products in an Order
*/

import java.util.ArrayList;

// Product class
class Product {

    String productName;
    double price;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    void displayProduct() {
        System.out.println("Product: " + productName + ", Price: $" + price);
    }
}

// Order class (aggregates Products)
class Order {

    int orderId;
    ArrayList<Product> products = new ArrayList<>();

    Order(int orderId) {
        this.orderId = orderId;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void displayOrder() {
        System.out.println("Order ID: " + orderId);
        for (Product product : products) {
            product.displayProduct();
        }
    }
}

// Customer class
class Customer {

    String name;
    ArrayList<Order> orders = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    // Method for customer to place an order
    void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order ID: " + order.orderId);
    }

    // Method to view all orders of the customer
    void viewOrders() {
        System.out.println("Orders for Customer: " + name);
        for (Order order : orders) {
            order.displayOrder();
        }
    }
}

// E-commerce platform demonstration
public class Customer {

    public static void main(String[] args) {

        // Creating products
        Product p1 = new Product("Laptop", 1200);
        Product p2 = new Product("Smartphone", 800);
        Product p3 = new Product("Headphones", 150);

        // Creating customer
        Customer customer = new Customer("Alice");

        // Creating orders
        Order order1 = new Order(101);
        order1.addProduct(p1);
        order1.addProduct(p3);

        Order order2 = new Order(102);
        order2.addProduct(p2);

        // Customer places orders
        customer.placeOrder(order1);
        customer.placeOrder(order2);

        // Customer views all orders
        System.out.println();
        customer.viewOrders();
    }
}
