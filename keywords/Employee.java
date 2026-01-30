// Employee Management System: This program demonstrates an Employee class with static variable and method, final variable for ID, 'this' keyword in constructor, and instanceof operator

public class Employee {

    // Static variable shared across all employees
    static String companyName = "Tech Solutions";

    // Static variable to count total employees
    static int totalEmployees = 0;

    // Final variable: cannot be changed once assigned
    final int id;

    // Instance variables
    String name;
    String designation;

    // Constructor using 'this' to resolve ambiguity
    public Employee(String name, int id, String designation) {
        this.name = name;           // resolves ambiguity
        this.id = id;               // final variable
        this.designation = designation;
        totalEmployees++;           // increment total employees
    }

    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Designation: " + designation);
    }
}

// Subclass with main method
class EmployeeDemo extends Employee {

    public EmployeeDemo(String name, int id, String designation) {
        super(name, id, designation);
    }

    public static void main(String[] args) {

        // Create employee objects
        EmployeeDemo emp1 = new EmployeeDemo("Alice", 101, "Developer");
        EmployeeDemo emp2 = new EmployeeDemo("Bob", 102, "Manager");

        // instanceof check before displaying details
        if (emp1 instanceof Employee) emp1.displayEmployeeDetails();
        if (emp2 instanceof Employee) emp2.displayEmployeeDetails();

        // Display total employees using static method
        Employee.displayTotalEmployees();
    }
}
