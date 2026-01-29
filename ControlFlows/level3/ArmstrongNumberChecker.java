// Checks whether a number is an Armstrong number using digit cube sum.

import java.util.Scanner;

public class ArmstrongNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        
        int originalNumber = number;
        int sum = 0;

        while (originalNumber != 0) {
            int remainder = originalNumber % 10;
            sum = sum + (remainder * remainder * remainder);
            originalNumber = originalNumber / 10;
        }

        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }
}
