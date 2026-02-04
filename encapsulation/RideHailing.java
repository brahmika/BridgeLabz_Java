/*
 * - Abstraction using the Vehicle abstract class
 * - Inheritance through Car, Bike, and Auto classes
 * - Interface implementation using GPS
 * - Encapsulation to secure driver and vehicle details
 * - Polymorphism by calculating fares dynamically for different vehicles
 */

// Interface for GPS functionality
interface GPS {

    // Get current location
    String getCurrentLocation();

    // Update location
    void updateLocation(String newLocation);
}

// Abstract base class for vehicles
abstract class Vehicle {

    // Encapsulated fields
    private int vehicleId;
    private String driverName;
    protected double ratePerKm;

    // Constructor
    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method to calculate fare
    public abstract double calculateFare(double distance);

    // Display vehicle details
    public void getVehicleDetails() {
        System.out.println(
                "Vehicle ID: " + vehicleId +
                        " | Driver: " + driverName
        );
    }
}

// Car class
class Car extends Vehicle implements GPS {

    private String location = "Unknown";

    // Constructor
    public Car(int id, String driverName, double ratePerKm) {
        super(id, driverName, ratePerKm);
    }

    // Calculate fare for car
    @Override
    public double calculateFare(double distance) {
        return ratePerKm * distance;
    }

    // Get current location
    @Override
    public String getCurrentLocation() {
        return location;
    }

    // Update location
    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Bike class
class Bike extends Vehicle implements GPS {

    private String location = "Unknown";

    // Constructor
    public Bike(int id, String driverName, double ratePerKm) {
        super(id, driverName, ratePerKm);
    }

    // Calculate fare for bike (cheaper)
    @Override
    public double calculateFare(double distance) {
        return ratePerKm * distance * 0.8;
    }

    // Get current location
    @Override
    public String getCurrentLocation() {
        return location;
    }

    // Update location
    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Auto class
class Auto extends Vehicle implements GPS {

    private String location = "Unknown";

    // Constructor
    public Auto(int id, String driverName, double ratePerKm) {
        super(id, driverName, ratePerKm);
    }

    // Calculate fare for auto
    @Override
    public double calculateFare(double distance) {
        return ratePerKm * distance * 1.1;
    }

    // Get current location
    @Override
    public String getCurrentLocation() {
        return location;
    }

    // Update location
    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Main class to demonstrate polymorphism
public class RideHailingApp {

    // Polymorphic fare calculation method
    public static void calculateFareForRide(Vehicle[] vehicles, double distance) {

        for (Vehicle v : vehicles) {

            // Display vehicle details
            v.getVehicleDetails();

            // Calculate fare dynamically
            double fare = v.calculateFare(distance);

            // Print fare
            System.out.println("Fare for " + distance + " km: " + fare);

        }
    }

    public static void main(String[] args) {

        // Polymorphic array of vehicles
        Vehicle[] vehicles = {
                new Car(101, "Alice", 15),
                new Bike(102, "Bob", 10),
                new Auto(103, "Charlie", 12)
        };

        // Calculate fares for a ride
        calculateFareForRide(vehicles, 10);
    }
}
