/*
   This program demonstrates the use of access modifiers in Java.
   The Student class uses public, protected, and private variables.
   Public methods are used to access and modify private data.
*/
public class Student {

    // Access modifiers
    public int rollNumber;        // public
    protected String name;        // protected
    private double cgpa;          // private

    // Constructor
    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    // Public method to access CGPA
    public double getCGPA() {
        return cgpa;
    }

    // Public method to modify CGPA
    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
    }
}

// Subclass PostgraduateStudent
class PostgraduateStudent extends Student {

    String specialization;

    public PostgraduateStudent(int rollNumber, String name, double cgpa, String specialization) {
        super(rollNumber, name, cgpa);
        this.specialization = specialization;
    }

    // Method accessing protected member
    public void displayPostgraduateDetails() {
        System.out.println("Roll Number: " + rollNumber); // public
        System.out.println("Name: " + name);               // protected (accessible)
        System.out.println("Specialization: " + specialization);
        System.out.println("CGPA: " + getCGPA());          // private via getter
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Anita", 8.6, "Data Science");

        pg.displayPostgraduateDetails();

        // Modifying CGPA using public method
        pg.setCGPA(9.1);
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}
