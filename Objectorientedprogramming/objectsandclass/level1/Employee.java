//OOPs L1
/* Problem Statement: Write a program to create an Employee class with attributes name, id, and salary. Add a method to display the details.*/
public class Employee{
	String name;
	int id;
	double salary;
	
	Employee(String name, int id, double salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	void displayDetails(){
		System.out.println("Name: " + name + ", Id: " + id + ", Salary: " + salary);
	}


	public static void main(String[] args){
		Employee employee = new Employee("Brahmika", 105, 10000);
		employee.displayDetails();
	}
}