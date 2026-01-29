// Computes the sum of natural numbers using a for loop and formula.

import java.util.Scanner;

class L1013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("The number is not a natural number");
            return;
        }

        // Sum using for loop
        int sumFor = 0;
        for (int i = 1; i <= n; i++) {
            sumFor += i;
        }

        // Sum using formula
        int sumFormula = n * (n + 1) / 2;

        System.out.println("Sum using for loop: " + sumFor);
        System.out.println("Sum using formula: " + sumFormula);

        if (sumFor == sumFormula) {
            System.out.println("Both results are correct and equal");
        } else {
            System.out.println("The results are not equal");
        }
    }
}
