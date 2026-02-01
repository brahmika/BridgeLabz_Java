/*
 Sample Problem 2: School System with Different Roles
 Description: Demonstrates hierarchical inheritance using Person as the superclass
 Goal: Model different school roles sharing common attributes with unique responsibilities
*/

class Person {
    String name;
    int age;

    // Constructor to initialize common person details
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display basic person details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Teacher extends Person {
    String subject;

    // Constructor to initialize teacher details
    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // Method to display teacher role
    void displayRole() {
        System.out.println("Role: Teacher");
    }
}

class Student extends Person {
    String grade;

    // Constructor to initialize student details
    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    // Method to display student role
    void displayRole() {
        System.out.println("Role: Student");
    }
}

class Staff extends Person {
    String department;

    // Constructor to initialize staff details
    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    // Method to display staff role
    void displayRole() {
        System.out.println("Role: Staff");
    }
}

public class SchoolSystem {
    public static void main(String[] args) {

        // Creating objects of different roles
        Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student student = new Student("Ananya", 16, "10th Grade");
        Staff staff = new Staff("Ramesh", 45, "Administration");

        // Displaying teacher details and role
        teacher.displayRole();
        teacher.displayDetails();

        // Displaying student details and role
        student.displayRole();
        student.displayDetails();

        // Displaying staff details and role
        staff.displayRole();
        staff.displayDetails();
    }
}
