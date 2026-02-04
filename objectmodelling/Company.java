/*
 This program demonstrates **composition**.
 A Company owns Departments, and each Department owns Employees.
 If the Company is deleted, all its Departments and Employees
 are also deleted.

*/

import java.util.ArrayList;

// Employee class (cannot exist without Department)
class Employee {

    String name;
    String role;

    // Constructor to initialize employee details
    Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // Method to display employee details
    void displayEmployee() {
        System.out.println("Employee Name: " + name + ", Role: " + role);
    }
}

// Department class (cannot exist without Company)
class Department {

    String departmentName;
    ArrayList<Employee> employees = new ArrayList<>();

    // Constructor to initialize department name
    Department(String departmentName) {
        this.departmentName = departmentName;
    }

    // Method to add employee to department
    void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    // Method to display all employees in the department
    void displayEmployees() {
        System.out.println("Department: " + departmentName);
        for (Employee employee : employees) {
            employee.displayEmployee();
        }
    }
}

// Company class (owns departments)
public class Company {

    String companyName;
    ArrayList<Department> departments = new ArrayList<>();

    // Constructor to initialize company name
    Company(String companyName) {
        this.companyName = companyName;
    }

    // Method to add a department to the company
    void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Method to display company structure
    void displayCompanyDetails() {
        System.out.println("Company: " + companyName);
        for (Department department : departments) {
            department.displayEmployees();
        }
    }

    public static void main(String[] args) {

        // Creating company.
        Company techCorp = new Company("TechCorp");

        // Adding departments
        techCorp.addDepartment("Engineering");
        techCorp.addDepartment("HR");

        // Adding employees to departments
        techCorp.departments.get(0).addEmployee("Alice", "Software Engineer");
        techCorp.departments.get(0).addEmployee("Bob", "DevOps Engineer");
        techCorp.departments.get(1).addEmployee("Clara", "HR Manager");

        // Display company structure
        techCorp.displayCompanyDetails();
        System.out.println("\nCompany deleted. All departments and employees are removed.");
    }
}
