// Convert text to uppercase using charAt() and compare with built-in toUpperCase()

import java.util.Scanner;

public class Quadratic  {

    static String convertToUpperUsingCharAt(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            result = result + ch;
        }
        return result;
    }

    static boolean compareStringsUsingCharAt(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter complete text: ");
        String input = sc.nextLine();

        String userUpper = convertToUpperUsingCharAt(input);

        String builtInUpper = input.toUpperCase();

        boolean result = compareStringsUsingCharAt(userUpper, builtInUpper);

        System.out.println("User-defined Uppercase: " + userUpper);
        System.out.println("Built-in Uppercase: " + builtInUpper);
        System.out.println("Comparison Result: " + result);

        sc.close();
    }
}
