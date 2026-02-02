/* Calculates employee bonus based on years of service */

import java.util.Scanner;

public class EmployeeBonusCalculator {

    // Main method where execution starts
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter salary
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        // Ask user to enter years of service
        System.out.print("Enter years of service: ");
        int years = sc.nextInt();

        // Initialize bonus amount to zero
        double bonus = 0.0;

        // Check if years of service is greater than 5
        if (years > 5) {

            // Calculate 5% bonus of salary
            bonus = salary * 0.05;
        }

        // Display the bonus amount
        System.out.println("The bonus amount is " + bonus);

        // Close the Scanner object
        sc.close();
    }
}
