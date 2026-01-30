/*
   Vehicle Registration System
   This program demonstrates the use of:
   1. Instance variables to store vehicle-specific details
   2. A class (static) variable shared among all vehicles
   3. Instance methods and class methods
*/

public class Vehicle {

    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable (same for all vehicles)
    static double registrationFee = 2500.0;

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    // Class method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Main method to test the class
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Alice", "Car");
        Vehicle v2 = new Vehicle("Bob", "Motorcycle");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        // Updating registration fee for all vehicles
        Vehicle.updateRegistrationFee(3000.0);

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
