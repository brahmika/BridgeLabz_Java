/*
 Vehicle and Transport System
 This program demonstrates inheritance and runtime polymorphism
 using a Vehicle hierarchy.
*/

public class Vehicle {

    // Maximum speed of the vehicle
    int maxSpeed;

    // Fuel type of the vehicle
    String fuelType;

    // Constructor to initialize vehicle details
    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // Displays vehicle information
    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Car class inherits from Vehicle
class Car extends Vehicle {

    // Seating capacity of the car
    int seatCapacity;

    // Constructor to initialize Car details
    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    // Displays Car-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Truck class inherits from Vehicle
class Truck extends Vehicle {

    // Load capacity in tons
    double loadCapacity;

    // Constructor to initialize Truck details
    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    // Displays Truck-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Motorcycle class inherits from Vehicle
class Motorcycle extends Vehicle {

    // Indicates whether the motorcycle has a sidecar
    boolean hasSideCar;

    // Constructor to initialize Motorcycle details
    Motorcycle(int maxSpeed, String fuelType, boolean hasSideCar) {
        super(maxSpeed, fuelType);
        this.hasSideCar = hasSideCar;
    }

    // Displays Motorcycle-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Side Car: " + hasSideCar);
    }
}

// TransportSystem class demonstrates polymorphism
class TransportSystem {

    // Main method starts program execution
    public static void main(String[] args) {

        // Vehicle array holding different subclass objects
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 12.5);
        vehicles[2] = new Motorcycle(160, "Petrol", false);

        // Dynamic method calls based on actual object type
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}

