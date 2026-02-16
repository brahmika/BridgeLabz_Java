/*
 * This program demonstrates:
 * - Generic Classes
 * - Bounded Type Parameters
 * - Wildcards
 * - Generic Methods
 *
 * It models different product categories such as Books,
 * Clothing, and Gadgets using a generic Product<T extends Category>.
 * Discounts are applied dynamically while maintaining type safety.
 */

package javagenerics;

import java.util.ArrayList;
import java.util.List;

interface Category {

    // Returns the name of the category
    String getCategoryName();
}

class BookCategory implements Category {

    // Returns category name for books.
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {

    // Returns category name for clothing.
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetsCategory implements Category {

    // Returns category name for gadgets.
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends Category> {

    private int id;
    private String name;
    private double price;
    private T category;

    // Initializes product with id, name, price, and category
    public Product(int id, String name, double price, T category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Returns the current product price
    public double getPrice() {
        return price;
    }

    // Updates the product price
    public void setPrice(double price) {
        this.price = price;
    }

    // Displays product details
    public void display() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Price: " + price +
                " | Category: " + category.getCategoryName());
    }
}

class MarketPlace {

    // Applies discount to any Product type using bounded generic method
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        double newPrice = product.getPrice() - discountAmount;
        product.setPrice(newPrice);
    }
}

public class DynamicOnlineMarketplace {

    // Entry point of the marketplace application.
    public static void main(String[] args) {

        BookCategory bookcategory = new BookCategory();
        ClothingCategory clothingcategory = new ClothingCategory();
        GadgetsCategory gadgetscategory = new GadgetsCategory();

        Product<BookCategory> book =
                new Product<>(1, "Java Programming", 500, bookcategory);

        Product<ClothingCategory> shirt =
                new Product<>(2, "T-shirt", 1200, clothingcategory);

        Product<GadgetsCategory> phone =
                new Product<>(3, "Smartphone", 25000, gadgetscategory);

        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        System.out.println("=== Before Discount ===");
        displayCatalog(catalog);

        // Apply discounts to selected products.
        MarketPlace.applyDiscount(book, 10);
        MarketPlace.applyDiscount(phone, 5);

        System.out.println("\n=== After Discount ===");
        displayCatalog(catalog);
    }

    // Displays all products using wildcard list
    public static void displayCatalog(List<? extends Product<?>> catalog) {
        for (Product<?> product : catalog) {
            product.display();
        }
    }
}
