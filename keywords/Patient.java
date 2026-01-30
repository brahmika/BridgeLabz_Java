// Hospital Management System: This program demonstrates a Patient class with static variable and method, final variable for patientID, 'this' keyword in constructor, and instanceof operator

public class Patient {

    // Static variable shared among all patients
    static String hospitalName = "City Hospital";

    // Static variable to count total patients
    static int totalPatients = 0;

    // Final variable: cannot be changed once assigned
    final int patientID;

    // Instance variables
    String name;
    int age;
    String ailment;

    // Constructor using 'this' to resolve ambiguity
    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID; // final variable
        totalPatients++;            // increment total patients
    }

    // Static method to display total patients
    public static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    // Method to display patient details
    public void displayPatientDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Patient ID: " + patientID);
    }
}

// Subclass with main method
class HospitalDemo extends Patient {

    public HospitalDemo(String name, int age, String ailment, int patientID) {
        super(name, age, ailment, patientID);
    }

    public static void main(String[] args) {

        // Create patient objects
        HospitalDemo p1 = new HospitalDemo("Alice", 30, "Fever", 101);
        HospitalDemo p2 = new HospitalDemo("Bob", 45, "Fracture", 102);

        // instanceof check before displaying details
        if (p1 instanceof Patient) p1.displayPatientDetails();
        if (p2 instanceof Patient) p2.displayPatientDetails();

        // Display total patients using static method
        Patient.getTotalPatients();
    }
}
