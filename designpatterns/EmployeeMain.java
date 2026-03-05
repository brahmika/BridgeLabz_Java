package designpatterns;

public class EmployeeMain {
    public static void main(String[] args) {

        try {

            // Step 3: Create original object
            Employee emp1 = new Employee("Brahmika", 101);

            // Step 4: Clone the object
            Employee emp2 = (Employee) emp1.clone();

            // Step 5: Verify both objects
            System.out.println("Original Employee:");
            emp1.display();

            System.out.println("Cloned Employee:");
            emp2.display();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
