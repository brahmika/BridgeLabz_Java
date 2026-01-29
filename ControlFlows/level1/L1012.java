// Computes the sum of natural numbers using a while loop and formula.

import java.util.Scanner;

class L1012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("The number is not a natural number");
            return;
        }

        // Sum using while loop
        int sumWhile = 0;
        int i = 1;

        while (i <= n) {
            sumWhile += i;
            i++;
        }

        // Sum using formula
        int sumFormula = n * (n + 1) / 2;

        System.out.println("Sum using while loop: " + sumWhile);
        System.out.println("Sum using formula: " + sumFormula);

        if (sumWhile == sumFormula) {
            System.out.println("Both results are correct and equal");
        } else {
            System.out.println("The results are not equal");
        }
    }
}
