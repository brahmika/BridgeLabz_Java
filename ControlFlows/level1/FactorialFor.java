/*
 This program calculates the factorial of a given number.
 It uses a for loop to multiply numbers from 1 to the given value.
 Factorial is not defined for negative numbers.
 The result is displayed to the user.
*/

import java.util.Scanner;

public class FactorialFor {

    // Main method where program execution starts
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Prompt user to enter an integer
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        // Check if the number is negative
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers");
            return;
        }

        // Initialize factorial value to 1
        int factorial = 1;

        // Loop from 1 to the given number to calculate factorial
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        // Display the factorial result
        System.out.println("The factorial of " + number + " is " + factorial);

        // Close the Scanner object
        sc.close();
    }
}
