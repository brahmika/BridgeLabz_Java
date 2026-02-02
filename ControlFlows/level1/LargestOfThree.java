/*
 This program checks which number is the largest among three given numbers.
 It takes three integer inputs from the user.
 Logical comparison operators are used to compare the values.
 The result of the comparison is displayed as output.
*/

import java.util.Scanner;

public class LargestOfThree {

    // Main method where program execution starts
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Prompt user to enter the first number
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        // Prompt user to enter the second number
        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        // Prompt user to enter the third number
        System.out.print("Enter third number: ");
        int number3 = sc.nextInt();

        // Check and display whether the first number is the smallest
        System.out.println(
            "Is the first number the smallest? " +
            (number1 < number2 && number1 < number3)
        );

        // Close the Scanner object
        sc.close();
    }
}
