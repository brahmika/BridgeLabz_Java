/*
 Sample Problem: Restaurant System using Hybrid Inheritance
 Description: Demonstrates hybrid inheritance by combining class inheritance and interface implementation
 Goal: Show how Chef and Waiter inherit common features and implement work-specific behavior
*/

interface Worker {
    // Method to be implemented by working roles
    void performDuties();
}

class Person {
    String name;
    int id;

    // Constructor to initialize common person details
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display basic person information
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {

    // Constructor to initialize chef details
    Chef(String name, int id) {
        super(name, id);
    }

    // Implementing performDuties for Chef
    public void performDuties() {
        System.out.println("Chef is preparing and cooking food");
    }
}

class Waiter extends Person implements Worker {

    // Constructor to initialize waiter details
    Waiter(String name, int id) {
        super(name, id);
    }

    // Implementing performDuties for Waiter
    public void performDuties() {
        System.out.println("Waiter is serving food to customers");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {

        // Creating Chef object
        Chef chef = new Chef("Rahul", 201);

        // Creating Waiter object
        Waiter waiter = new Waiter("Amit", 301);

        // Displaying chef details and duties
        chef.displayDetails();
        chef.performDuties();

        // Displaying waiter details and duties
        waiter.displayDetails();
        waiter.performDuties();
    }
}
