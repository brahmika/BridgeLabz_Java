/*
 Sample Problem: Vehicle System using Hybrid Inheritance
 Description: Demonstrates hybrid inheritance with Vehicle as superclass,
 PetrolVehicle implementing Refuelable interface, and ElectricVehicle having its own behavior
 Goal: Show how interfaces allow adding multiple behaviors while keeping shared attributes in the superclass
*/

interface Refuelable {
    // Method to be implemented by refuelable vehicles
    void refuel();
}

class Vehicle {
    String model;
    int maxSpeed;

    // Constructor to initialize vehicle details
    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Method to display basic vehicle information
    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {

    // Constructor to initialize electric vehicle details
    ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    // Method to charge the electric vehicle
    void charge() {
        System.out.println("Charging the electric vehicle.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {

    // Constructor to initialize petrol vehicle details
    PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    // Implementing refuel method from Refuelable interface
    public void refuel() {
        System.out.println("Refueling the petrol vehicle.");
    }
}

public class VehicleSystem {
    public static void main(String[] args) {

        // Creating ElectricVehicle object
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 250);

        // Creating PetrolVehicle object
        PetrolVehicle pv = new PetrolVehicle("Honda Civic", 180);

        // Displaying electric vehicle info and charging
        ev.displayInfo();
        ev.charge();

        // Displaying petrol vehicle info and refueling
        pv.displayInfo();
        pv.refuel();
    }
}
