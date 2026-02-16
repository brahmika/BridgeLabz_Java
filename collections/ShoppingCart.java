/*
 * This program implements a simple Shopping Cart system.
 * A HashMap is used to store product prices for quick lookup.
 * A LinkedHashMap is used to maintain the order in which items are added to the cart.
 * A TreeMap is used to display cart items sorted by price.
 */
package collections;
import java.util.*;


public class ShoppingCart {

    private Map<String, Double> productCatalog = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();

    // Adds a product with its price to the catalog
    public void addProductToCatalog(String product, double price) {
        productCatalog.put(product, price);
    }

    // Adds an item to the cart and maintains insertion order
    public void addToCart(String product, int quantity) {
        if (productCatalog.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Product not found in catalog.");
        }
    }

    // Displays cart items in insertion order
    public void displayCart() {
        System.out.println("Cart Items (Insertion Order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue()
                    + " - Price: $" + productCatalog.get(entry.getKey()));
        }
    }

    // Displays cart items sorted by price using TreeMap
    public void displaySortedByPrice() {
        System.out.println("\nCart Items Sorted by Price:");

        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

        for (String product : cart.keySet()) {
            double price = productCatalog.get(product);
            sortedByPrice
                    .computeIfAbsent(price, k -> new ArrayList<>())
                    .add(product);
        }

        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " - Quantity: " + cart.get(product)
                        + " - Price: $" + entry.getKey());
            }
        }
    }

    // Calculates total cart value
    public void displayTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productCatalog.get(entry.getKey()) * entry.getValue();
        }
        System.out.println("\nTotal Cart Value: $" + total);
    }

    // Entry point to test the shopping cart
    public static void main(String[] args) {

        ShoppingCart cartSystem = new ShoppingCart();

        cartSystem.addProductToCatalog("Laptop", 800);
        cartSystem.addProductToCatalog("Mouse", 20);
        cartSystem.addProductToCatalog("Keyboard", 50);

        cartSystem.addToCart("Laptop", 1);
        cartSystem.addToCart("Mouse", 2);
        cartSystem.addToCart("Keyboard", 1);

        cartSystem.displayCart();
        cartSystem.displaySortedByPrice();
        cartSystem.displayTotal();
    }
}
