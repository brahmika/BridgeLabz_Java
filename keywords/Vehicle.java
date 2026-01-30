// Vehicle Registration System: This program demonstrates a Vehicle class with static variable and method, final variable for registrationNumber, 'this' keyword in constructor, and instanceof operator

public class Vehicle {

    // Static variable shared across all vehicles
    static double registrationFee = 500.0;

    // Final variable: cannot be changed once assigned
    final String registrationNumber;

    // Instance variables
    String ownerName;
    String vehicleType;

    // Constructor using 'this' to resolve ambiguity
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;             // resolves ambiguity
        this.vehicleType = vehicleType;         // resolves ambiguity
        this.registrationNumber = registrationNumber; // final variable
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Updated Registration Fee: ₹" + registrationFee);
    }

    // Method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }
}

// Subclass with main method
class VehicleDemo extends Vehicle {

    public VehicleDemo(String ownerName, String vehicleType, String registrationNumber) {
        super(ownerName, vehicleType, registrationNumber);
    }

    public static void main(String[] args) {

        // Create vehicle objects
        VehicleDemo v1 = new VehicleDemo("Alice", "Car", "REG101");
        VehicleDemo v2 = new VehicleDemo("Bob", "Bike", "REG102");

        // instanceof check before displaying details
        if (v1 instanceof Vehicle) v1.displayVehicleDetails();
        if (v2 instanceof Vehicle) v2.displayVehicleDetails();

        // Update registration fee using static method
        Vehicle.updateRegistrationFee(750.0);

        // Display details again after updating fee
        if (v1 instanceof Vehicle) v1.displayVehicleDetails();
        if (v2 instanceof Vehicle) v2.displayVehicleDetails();
    }
}
