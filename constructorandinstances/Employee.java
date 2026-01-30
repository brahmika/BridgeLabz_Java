/*  This program demonstrates the use of access modifiers in Java.
   Employee is the parent class with public, protected, and private members.
   Manager is a subclass that accesses public and protected members,
   while private members are accessed through public methods.*/

public class Employee{
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary){
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
}

class Manager extends Employee{
    String designation;

    public Manager(int employeeID, String department, double salary, String designation) {
        super(employeeID, department, salary);
        this.designation = designation;
    }

    public void displayManagerDetails(){
        System.out.println("Employee ID: " + employeeID);       // public
        System.out.println("Department: " + department);       // protected
        System.out.println("Salary: " + getSalary());         // private via getter
        System.out.println("Designation: " + designation);
    }
    public static void main(String[] args) {
        Manager m = new Manager(101, "IT", 75000, "Project Manager");

        m.displayManagerDetails();

        // Modifying salary using public method
        m.setSalary(80000);
        System.out.println("Updated Salary: " + m.getSalary());
    }
}