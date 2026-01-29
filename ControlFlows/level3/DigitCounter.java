import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get integer input
        int number = sc.nextInt();

        int count = 0;

        // Handle the case when number is 0
        if (number == 0) {
            count = 1;
        } else {
            // Loop until number becomes 0
            while (number != 0) {
                number = number / 10; // remove last digit
                count++;              // increase count
            }
        }

        // Display the result
        System.out.println("Number of digits: " + count);
    }
}
