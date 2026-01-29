// Reverses a number by storing its digits in an array and printing in reverse order.

import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int tempNumber = number;

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        while (tempNumber != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }
                digits = temp;
            }

            digits[index] = tempNumber % 10;
            tempNumber /= 10;
            index++;
        }

        System.out.println("Reversed number digits:");
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}
