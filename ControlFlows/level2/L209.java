// Finds the greatest factor of a number excluding itself.

import java.util.Scanner;

class L209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int greatestFactor = 1;

        
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }

        System.out.println("The greatest factor of " + number + " besides itself is " + greatestFactor);
    }
}
