/*
 This program demonstrates an association relationship.
 Doctors and Patients interact through consultations.
 A doctor can consult multiple patients, and a patient
 can consult multiple doctors.
*/

import java.util.ArrayList;

// Patient class.
class Patient {

    String name;
    ArrayList<Doctor> doctors = new ArrayList<>();

    Patient(String name) {
        this.name = name;
    }

    // Method to add doctor to patient's consultation list
    void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }
}

// Doctor class
class Doctor {

    String name;
    String specialization;
    ArrayList<Patient> patients = new ArrayList<>();

    Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    // Method to consult a patient
    void consult(Patient patient) {

        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this); // association link
        }

        System.out.println("Doctor " + name +
                " (" + specialization + ")" +
                " is consulting patient " + patient.name);
    }
}

// Hospital class
public class Hospital {

    String hospitalName;
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();

    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    void addPatient(Patient patient) {
        patients.add(patient);
    }

    public static void main(String[] args) {

        Hospital hospital = new Hospital("City Care Hospital");

        Doctor d1 = new Doctor("Dr. Sharma", "Cardiology");
        Doctor d2 = new Doctor("Dr. Khan", "Neurology");

        Patient p1 = new Patient("Amit");
        Patient p2 = new Patient("Riya");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
    }
}
