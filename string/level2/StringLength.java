// Count characters using charAt() and handle runtime exception

import java.util.Scanner;

public class StringLength {

    static int findLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        }
        catch (RuntimeException e) {
            return count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.next();

        int userLength = findLength(input);
        int builtInLength = input.length();

        System.out.println("User-defined Length: " + userLength);
        System.out.println("Built-in Length: " + builtInLength);

        sc.close();
    }
}
