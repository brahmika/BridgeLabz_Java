/*
 * This program demonstrates:
 * - Abstraction using an abstract Vehicle class
 * - Inheritance through Car, Bike, and Truck classes
 * - Interface implementation using Insurable
 * - Encapsulation to protect sensitive insurance details
 * - Polymorphism by processing different vehicles uniformly
 */

// Insurance-related behavior
interface Insurable {

    // Calculate insurance cost
    double calculateInsurance();

    // Provide insurance details
    String getInsuranceDetails();
}

// Abstract base class for all vehicles
abstract class Vehicle {

    // Encapsulated fields
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    // Sensitive information (hidden)
    private String insurancePolicyNumber;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policyNumber;
    }

    // Abstract method for rental calculation
    public abstract double calculateRentalCost(int days);

    // Getter for vehicle type
    public String getType() {
        return type;
    }

    // Mask insurance policy number
    protected String getMaskedPolicyNumber() {
        return "XXXX-" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }
}

// Car class
class Car extends Vehicle implements Insurable {

    // Constructor
    public Car(String number, double rate, String policyNumber) {
        super(number, "Car", rate, policyNumber);
    }

    // Calculate rental cost
    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    // Calculate insurance
    @Override
    public double calculateInsurance() {
        return 500;
    }

    // Insurance details
    @Override
    public String getInsuranceDetails() {
        return "Car Insurance | Policy: " + getMaskedPolicyNumber();
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {

    // Constructor
    public Bike(String number, double rate, String policyNumber) {
        super(number, "Bike", rate, policyNumber);
    }

    // Calculate rental cost
    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    // Calculate insurance
    @Override
    public double calculateInsurance() {
        return 200;
    }

    // Insurance details
    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance | Policy: " + getMaskedPolicyNumber();
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {

    // Constructor
    public Truck(String number, double rate, String policyNumber) {
        super(number, "Truck", rate, policyNumber);
    }

    // Calculate rental cost
    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days * 1.2;
    }

    // Calculate insurance
    @Override
    public double calculateInsurance() {
        return 1000;
    }

    // Insurance details
    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance | Policy: " + getMaskedPolicyNumber();
    }
}

// Main class to demonstrate polymorphism
public class VehicleRental {

    public static void main(String[] args) {

        // Polymorphic array of vehicles
        Vehicle[] vehicles = {
                new Car("CAR101", 1000, "POL12345"),
                new Bike("BIKE202", 500, "POL67890"),
                new Truck("TRK303", 2000, "POL54321")
        };

        // Iterate through vehicles.
        for (Vehicle v : vehicles) {

            // Calculate rental cost
            double rentalCost = v.calculateRentalCost(5);

            // Cast to Insurable
            Insurable insurable = (Insurable) v;

            // Print final details
            System.out.println(
                    v.getType() +
                            " | Rental Cost: " + rentalCost +
                            " | Insurance Cost: " + insurable.calculateInsurance()
            );
        }
    }
}
