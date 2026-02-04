/*
 * This program demonstrates Object-Oriented Programming concepts in Java:
 * - Encapsulation using private fields and getter/setter methods
 * - Abstraction using an abstract class and abstract methods
 * - Interface implementation for department-related behavior
 * - Inheritance through FullTimeEmployee and PartTimeEmployee classes
 * - Polymorphism by handling different employee types using Employee references
 */

import java.util.ArrayList;

// Interface defining department-related behavior
interface Department {

    // Assigns a department to an employee
    void assignDepartment(String deptName);

    // Returns department details of an employee
    String getDepartmentDetails();
}

// Abstract class representing a generic employee
abstract class Employee implements Department {

    // Encapsulated fields
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // Constructor to initialize employee details
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Displays employee details
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name:" + name);
        System.out.println("Department:" + department);
        System.out.println("Salary:" + calculateSalary());
    }

    // Returns employee ID
    public int getEmployeeId() {
        return employeeId;
    }

    // Returns employee name
    public String getName() {
        return name;
    }

    // Returns base salary
    public double getBaseSalary() {
        return baseSalary;
    }

    // Updates base salary (accessible to subclasses)
    protected void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Assigns department (interface method implementation)
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    // Returns department details (interface method implementation)
    public String getDepartmentDetails() {
        return department;
    }
}

// Class representing a full-time employee
class FullTimeEmployee extends Employee {

    // Constructor for full-time employee
    public FullTimeEmployee(int id, String name, double fixedSalary) {
        super(id, name, fixedSalary);
    }

    // Calculates salary for full-time employee
    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }
}

// Class representing a part-time employee
class PartTimeEmployee extends Employee {

    // Fields specific to part-time employee
    private int hoursWorked;
    private double hourlyRate;

    // Constructor for part-time employee
    public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Calculates salary based on hours worked
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Main class to test the employee management system
public class Company {

    // Main method: program execution starts here
    public static void main(String[] args) {

        // Creating employee objects using polymorphism
        Employee e1 = new FullTimeEmployee(101, "Alice", 50000);
        Employee e2 = new PartTimeEmployee(102, "Bob", 8, 500);

        // Assigning departments
        e1.assignDepartment("IT");
        e2.assignDepartment("HR");

        // Storing employees in a list
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);

        // Displaying employee details
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
