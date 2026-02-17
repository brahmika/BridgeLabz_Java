/*
 Takes two numbers from user and performs division.
 Handles ArithmeticException and InputMismatchException.
*/
package exceptions;

import java.util.*;

public class UncheckedException {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int num = sc.nextInt();

            System.out.print("Enter denominator: ");
            int den = sc.nextInt();

            int result = num / den;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers only.");
        }

        sc.close();
    }
}
