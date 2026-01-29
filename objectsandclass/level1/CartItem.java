// Objects L110
class CartItem {

    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0;
    }

    void addItem(int qty) {
        quantity = quantity + qty;
        System.out.println(qty + " item(s) added to cart");
    }

    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity = quantity - qty;
            System.out.println(qty + " item(s) removed from cart");
        } else {
            System.out.println("Not enough items in cart to remove");
        }
    }

    void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.println("Total Cost: " + totalCost);
    }

    public static void main(String[] args) {

        CartItem item = new CartItem("Laptop", 50000);

        item.addItem(2);
        item.removeItem(1);
        item.displayTotalCost();
    }
}
