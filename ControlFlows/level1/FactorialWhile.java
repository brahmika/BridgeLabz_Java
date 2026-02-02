/*
 This program calculates the factorial of a given number using a while loop.
 It repeatedly multiplies numbers starting from 1 up to the given number.
 The program checks and handles negative input values.
 Finally, it displays the calculated factorial to the user.
*/

import java.util.Scanner;

public class FactorialWhile {

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

        // Initialize factorial and loop counter
        int factorial = 1;
        int i = 1;

        // Calculate factorial using while loop
        while (i <= number) {
            factorial *= i;
            i++;
        }

        // Display the factorial result
        System.out.println("The factorial of " + number + " is " + factorial);

        // Close the Scanner object
        sc.close();
    }
}
