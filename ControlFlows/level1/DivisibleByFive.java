// Import Scanner class to take input from the user
import java.util.Scanner;

// Class to check if a number is divisible by 5
public class DivisibleByFive {

    // Main method where program execution starts
    public static void main(String[] args) {

        // Create Scanner object to read input from keyboard
        Scanner input = new Scanner(System.in);

        // Read an integer value from the user
        int num = input.nextInt();

        // Check if the number is divisible by 5
        if (num % 5 == 0) {

            // Print message if number is divisible by 5
            System.out.println(num + " is divisible by 5");

        } else {

            // Print message if number is not divisible by 5
            System.out.println(num + " is not divisible by 5");
        }

        // Close the Scanner object
        input.close();
    }
}
