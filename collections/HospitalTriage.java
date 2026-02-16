package collections;
import java.util.PriorityQueue;

/*
 * This program simulates a hospital triage system using a PriorityQueue.
 * Each patient has a name and a severity level. Patients with higher
 * severity are treated first. A custom comparator is used to ensure
 * that the patient with the highest severity has the highest priority.
 */

class Patient {

    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() { return name; }
    public int getSeverity() { return severity; }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {

    // Simulates treating patients based on highest severity first
    public static void treatPatients(PriorityQueue<Patient> queue) {

        System.out.println("Treatment Order:");

        while (!queue.isEmpty()) {
            Patient patient = queue.poll();  // Remove highest priority patient
            System.out.println(patient.getName());
        }
    }

    // Entry point of the program to test hospital triage system
    public static void main(String[] args) {

        // PriorityQueue with custom comparator (higher severity first)
        PriorityQueue<Patient> queue =
                new PriorityQueue<>((p1, p2) -> p2.getSeverity() - p1.getSeverity());

        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        treatPatients(queue);
    }
}
