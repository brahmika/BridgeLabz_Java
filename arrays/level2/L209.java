
import java.util.Scanner;

class L210 {
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

        int[] frequency = new int[10];

        for (int i = 0; i < index; i++) {
            frequency[digits[i]]++;
        }

        System.out.println("Digit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " = " + frequency[i]);
            }
        }
    }
}

