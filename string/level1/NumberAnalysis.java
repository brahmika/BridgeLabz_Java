// Demonstrate IllegalArgumentException using substring() with wrong indices

import java.util.Scanner;

public class NumberAnalysis  {

    static void generateException(String str) {
        System.out.println("Substring: " + str.substring(5, 2));
    }

    static void handleException(String str) {
        try {
            System.out.println("Substring: " + str.substring(5, 2));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
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
