package linkedlist;

/*
Inventory Management System using Singly Linked List.
Each node stores Item ID, Name, Quantity, and Price.
Supports insertion, deletion, update, search, sorting,
and total inventory value calculation.
*/

class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;

    ItemNode next;

    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    private ItemNode head;

    // Add at Beginning
    void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    //Add at End
    void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);

        if (head == null) {
            head = newNode;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    //Add at Specific Position (1-based)
    void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos <= 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode temp = head;
        int count = 1;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            addAtEnd(id, name, qty, price);
            return;
        }

        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //Remove by Item ID
    void removeById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed: " + id);
            return;
        }

        ItemNode temp = head;
        while (temp.next != null) {
            if (temp.next.itemId == id) {
                temp.next = temp.next.next;
                System.out.println("Item removed: " + id);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found.");
    }

    //Update Quantity
    void updateQuantity(int id, int newQty) {
        ItemNode temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated for item ID: " + id);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found.");
    }

    // Search by ID
    void searchById(int id) {
        ItemNode temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found.");
    }

    // Search by Name
    void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found.");
    }

    //Total Inventory Value
    void totalInventoryValue() {
        double total = 0;
        ItemNode temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: ₹" + total);
    }

    // ️Sort by Name
    void sortByName(boolean ascending) {
        for (ItemNode i = head; i != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0) ||
                        (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {
                    swapData(i, j);
                }
            }
        }
    }

    // Sort by Price
    void sortByPrice(boolean ascending) {
        for (ItemNode i = head; i != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.price > j.price) ||
                        (!ascending && i.price < j.price)) {
                    swapData(i, j);
                }
            }
        }
    }

    // Display All Items
    void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        ItemNode temp = head;
        System.out.println("\nInventory List:");
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // Helper Methods
    private void swapData(ItemNode a, ItemNode b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    private void displayItem(ItemNode item) {
        System.out.println(
                "ID: " + item.itemId +
                        ", Name: " + item.itemName +
                        ", Qty: " + item.quantity +
                        ", Price: ₹" + item.price
        );
    }
}

public class InventorySystem{
    public static void main(String[] args) {

        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtEnd(101, "Keyboard", 10, 1500);
        inventory.addAtEnd(102, "Mouse", 20, 700);
        inventory.addAtBeginning(103, "Monitor", 5, 12000);
        inventory.addAtPosition(2, 104, "Laptop Stand", 8, 2000);

        inventory.displayAll();

        inventory.searchById(102);
        inventory.searchByName("Monitor");

        inventory.updateQuantity(101, 15);

        inventory.totalInventoryValue();

        inventory.sortByPrice(true);
        System.out.println("\nSorted by Price (Ascending):");
        inventory.displayAll();

        inventory.sortByName(false);
        System.out.println("\nSorted by Name (Descending):");
        inventory.displayAll();

        inventory.removeById(102);
        inventory.displayAll();
    }
}

