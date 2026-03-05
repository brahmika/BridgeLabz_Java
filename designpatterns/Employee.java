package designpatterns;

public class Employee implements Cloneable {

    // Step 1: Fields
    private String name;
    private int id;

    // Constructor
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Display method
    public void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
    }

    // Step 2: Override clone()
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}