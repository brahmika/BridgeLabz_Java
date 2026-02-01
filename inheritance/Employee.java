/*Employee is the base class representing common employee details.
 */
public class Employee{
    String name;
    int id;
    double salary;

    //Constructor to initialize Employee details
    Employee(String name, int id, double salary)
    {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    //Displays basic employee details
    public void displayDetails(){
        System.out.println("Employee name: "+ name);
        System.out.println("Employee id:" + id);
        System.out.println("Employee salary: "+ salary);
    }
}
// manager subclass inherits from employee superclass
class Manager extends Employee{
    int teamSize;

    //Constructor to initialize Manager details
    Manager(String name, int id, double salary, int teamSize){
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @java.lang.Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Developer class represents employees who write code.
class Developer extends Employee {
    String programmingLanguage;

    //Constructor to initialize Developer details
    Developer(String name, int id, double salary, int teamSize, String programmingLanguage){
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @java.lang.Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}
// Intern class inherits from Employee
class Intern extends Employee {

    // Duration of internship in months
    int durationMonths;

    // Constructor to initialize Intern details
    Intern(String name, int id, double salary, int durationMonths) {
        super(name, id, salary);
        this.durationMonths = durationMonths;
    }

    // Overriding displayDetails method for Intern
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Duration: " + durationMonths + " months");
    }
}

class Company{
    public static void main(String[] args){

         /* Creating Employee references
           holding different subclass objects */
        Employee employee = new Manager("Alice", 101, 50000, 5);
        Employee employee1 = new Developer("Bob", 101, 50000, 5, "Python");
        Employee employee2 = new Intern("Alicia", 101, 430000, 3);

        employee.displayDetails();

        employee1.displayDetails();

        employee2.displayDetails();
    }
}