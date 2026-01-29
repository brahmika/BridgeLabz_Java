// Demonstrate NumberFormatException using Integer.parseInt()

import java.util.Scanner;

public class RuntimeException01 {

    static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        }
        catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException");
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a value: ");
        String input = sc.next();

        try {
            generateException(input);
        }
        catch (RuntimeException e) {
            System.out.println("Exception occurred in generateException()");
        }

        handleException(input);

        sc.close();
    }
}
