// University Student Management: This program demonstrates a Student class with static variable and method, final variable for rollNumber, 'this' keyword in constructor, and instanceof operator

public class Student {

    // Static variable shared by all students
    static String universityName = "Global University";

    // Static variable to count total students
    static int totalStudents = 0;

    // Final variable: cannot be changed once assigned
    final int rollNumber;

    // Instance variables
    String name;
    char grade;

    // Constructor using 'this' to resolve ambiguity
    public Student(String name, int rollNumber, char grade) {
        this.name = name;           // resolves ambiguity
        this.rollNumber = rollNumber; // final variable
        this.grade = grade;
        totalStudents++;             // increment total students
    }

    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    // Method to update grade
    public void updateGrade(char newGrade) {
        this.grade = newGrade;
    }
}

// Subclass with main method
class StudentDemo extends Student {

    public StudentDemo(String name, int rollNumber, char grade) {
        super(name, rollNumber, grade);
    }

    public static void main(String[] args) {

        // Create student objects
        StudentDemo s1 = new StudentDemo("Alice", 101, 'A');
        StudentDemo s2 = new StudentDemo("Bob", 102, 'B');

        // instanceof check before displaying details
        if (s1 instanceof Student) s1.displayStudentDetails();
        if (s2 instanceof Student) s2.displayStudentDetails();

        // Update grade
        s2.updateGrade('A');

        System.out.println("After updating grades:");

        if (s1 instanceof Student) s1.displayStudentDetails();
        if (s2 instanceof Student) s2.displayStudentDetails();

        // Display total students
        Student.displayTotalStudents();
    }
}
