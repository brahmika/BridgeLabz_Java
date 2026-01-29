// Prints whether numbers from 1 to n are odd or even.

import java.util.Scanner;

public class OddEvenPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number < 1) {
            System.out.println("The number is not a natural number");
            return;
        }

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is an even number");
            } else {
                System.out.println(i + " is an odd number");
            }
        }
    }
}
