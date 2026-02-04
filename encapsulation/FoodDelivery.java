/*
 * This program demonstrates:
 * - Abstraction using the FoodItem abstract class
 * - Inheritance through VegItem and NonVegItem classes
 * - Interface implementation using Discountable
 * - Encapsulation to protect order details like price and quantity
 * - Polymorphism by processing different food items in a single order
 */

// Interface for discount-related functionality
interface Discountable {

    // Apply discount on total price
    double applyDiscount();

    // Return discount details
    String getDiscountDetails();
}

// Abstract base class for food items
abstract class FoodItem {

    // Encapsulated fields
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method to calculate total price
    public abstract double calculateTotalPrice();

    // Display item details
    public void getItemDetails() {
        System.out.println(
                "Item: " + itemName +
                        " | Quantity: " + quantity +
                        " | Total Price: " + calculateTotalPrice()
        );
    }

    // Protected getters for subclasses
    protected double getPrice() {
        return price;
    }

    protected int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }
}

// Veg food item class
class VegItem extends FoodItem implements Discountable {

    // Constructor
    public VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    // Calculate total price for veg items
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    // Apply discount
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }

    // Discount details
    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: 10%";
    }
}

// Non-veg food item class
class NonVegItem extends FoodItem implements Discountable {

    // Constructor
    public NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    // Calculate total price with extra charge
    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 50;
    }

    // Apply discount
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    // Discount details
    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5%";
    }
}

// Main class to demonstrate polymorphism
public class FoodDeliverySystem {

    // Process order using polymorphism
    public static void processOrder(FoodItem[] items) {

        for (FoodItem item : items) {

            // Calculate discount if applicable
            double discount = 0;
            if (item instanceof Discountable) {
                discount = ((Discountable) item).applyDiscount();
            }

            // Final price calculation
            double finalPrice = item.calculateTotalPrice() - discount;

            // Display order summary
            System.out.println(
                    item.getItemName() +
                            " | Final Price: " + finalPrice
            );
        }
    }

    public static void main(String[] args) {

        // Polymorphic array of food items
        FoodItem[] order = {
                new VegItem("Paneer Butter Masala", 250, 2),
                new NonVegItem("Chicken Biryani", 300, 1)
        };

        // Process the order
        processOrder(order);
    }
}
