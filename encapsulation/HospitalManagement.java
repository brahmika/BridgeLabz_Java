/*
 * Hospital Patient Management System
 * ----------------------------------
 * This program demonstrates:
 * - Abstraction using the Patient abstract class
 * - Inheritance through InPatient and OutPatient classes
 * - Interface implementation using MedicalRecord
 * - Encapsulation to protect sensitive medical data
 * - Polymorphism by handling different patient types dynamically
 */

// Interface for medical record handling.
interface MedicalRecord {

    // Add a medical record
    void addRecord(String diagnosis);

    // View medical records
    String viewRecords();
}

// Abstract base class for patients
abstract class Patient {

    // Encapsulated basic patient details
    private int patientId;
    private String name;
    private int age;

    // Sensitive medical information
    private String medicalHistory;

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = "No records";
    }

    // Abstract method for bill calculation
    public abstract double calculateBill();

    // Display patient details
    public void getPatientDetails() {
        System.out.println(
                "ID: " + patientId +
                        " | Name: " + name +
                        " | Age: " + age +
                        " | Bill: " + calculateBill()
        );
    }

    // Protected method to update medical history
    protected void updateMedicalHistory(String record) {
        this.medicalHistory = record;
    }

    // Protected method to access medical history
    protected String getMedicalHistory() {
        return medicalHistory;
    }
}

// In-patient class
class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;

    // Constructor
    public InPatient(int id, String name, int age, int daysAdmitted, double dailyCharge) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    // Calculate bill for in-patient
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    // Add medical record
    @Override
    public void addRecord(String diagnosis) {
        updateMedicalHistory(diagnosis);
    }

    // View medical records
    @Override
    public String viewRecords() {
        return getMedicalHistory();
    }
}

// Out-patient class
class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    // Constructor
    public OutPatient(int id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    // Calculate bill for out-patient
    @Override
    public double calculateBill() {
        return consultationFee;
    }

    // Add medical record
    @Override
    public void addRecord(String diagnosis) {
        updateMedicalHistory(diagnosis);
    }

    // View medical records
    @Override
    public String viewRecords() {
        return getMedicalHistory();
    }
}

// Main class to demonstrate polymorphism
public class HospitalManagementSystem {

    public static void main(String[] args) {

        // Polymorphic array of patients
        Patient[] patients = {
                new InPatient(101, "Alice", 40, 4, 2500),
                new OutPatient(102, "Bob", 28, 900)
        };

        // Iterate through patients
        for (Patient p : patients) {

            // Display patient details dynamically
            p.getPatientDetails();

            // Access medical records using interface
            MedicalRecord record = (MedicalRecord) p;
            record.addRecord("General Checkup");

            // Display medical records
            System.out.println("Medical Record: " + record.viewRecords());
        }
    }
}
