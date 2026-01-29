// Demonstrate ArrayIndexOutOfBoundsException by accessing invalid array index

import java.util.Scanner;

public class BMI  {

    static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        try {
            generateException(names);
        }
        catch (RuntimeException e) {
            System.out.println("Exception occurred in generateException()");
        }

        handleException(names);

        sc.close();
    }
}
