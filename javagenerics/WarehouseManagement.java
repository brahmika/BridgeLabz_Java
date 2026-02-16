/*
 * Warehouse Management System
 *
 * Different warehouse item categories such as Electronics,
 * Groceries, and Furniture are managed using a generic
 * Storage<T extends WarehouseItem> class.
 * The system ensures type safety while storing and
 * displaying multiple item types dynamically.
 */

package javagenerics;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {

    private int id;
    private String name;
    private double price;

    // Constructor to initialize warehouse item details
    public WarehouseItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Returns item ID
    public int getId() {
        return id;
    }

    // Displays basic item details
    public void display() {
        System.out.println("ID: " + id + " , Name: " + name + " , Price: " + price);
    }
}

class Electronics extends WarehouseItem {

    private int warrantyYears;

    // Constructor for Electronics item.
    public Electronics(int id, String name, double price, int warrantyYears) {
        super(id, name, price);
        this.warrantyYears = warrantyYears;
    }

    // Displays electronics item details including warranty
    @Override
    public void display() {
        super.display();
        System.out.println("Warranty: " + warrantyYears + " years");
    }
}

class Groceries extends WarehouseItem {

    private String expiryDate;

    // Constructor for Grocery item
    public Groceries(int id, String name, double price, String expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    // Displays grocery item details including expiry date
    @Override
    public void display() {
        super.display();
        System.out.println("Expiry Date: " + expiryDate);
    }
}

class Furniture extends WarehouseItem {

    private String material;

    // Constructor for Furniture item
    public Furniture(int id, String name, double price, String material) {
        super(id, name, price);
        this.material = material;
    }

    // Displays furniture item details including material
    @Override
    public void display() {
        super.display();
        System.out.println("Material: " + material);
    }
}

class Storage<T extends WarehouseItem> {

    private List<T> items;

    // Initializes storage list
    public int[] storage() {
        items = new ArrayList<>();
        return new int[0];
    }

    // Adds item to storage
    public void addItem(T item) {
        items.add(item);
    }

    // Retrieves item by index
    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    // Removes item based on ID
    public boolean removeById(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    // Returns all stored items
    public List<T> getAllItems() {
        return items;
    }
}

public class WarehouseManagement {

    // Entry point of warehouse management system
    public static void main(String[] args) {

        // Electronics Storage
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics(1, "Laptop", 80000, 2));
        electronicsStorage.addItem(new Electronics(2, "Smartphone", 50000, 1));

        // Grocery Storage
        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries(3, "Milk", 50, "20-02-2026"));
        groceryStorage.addItem(new Groceries(4, "Rice", 1200, "01-12-2026"));

        // Furniture Storage
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture(5, "Chair", 2500, "Wood"));
        furnitureStorage.addItem(new Furniture(6, "Table", 7000, "Metal"));

        // Display All
        System.out.println("Electronics");
        displayAll(electronicsStorage.getAllItems());

        System.out.println("Groceries ");
        displayAll(groceryStorage.getAllItems());

        System.out.println(" Furniture");
        displayAll(furnitureStorage.getAllItems());

        // Remove Example
        System.out.println("Removing item with ID 2 from Electronics...");
        electronicsStorage.removeById(2);

        System.out.println("=== Electronics After Removal ===");
        displayAll(electronicsStorage.getAllItems());
    }

    // Displays items using upper bounded wildcard
    public static void displayAll(List<? extends WarehouseItem> list) {
        for (WarehouseItem item : list) {
            item.display();
        }
    }
}
