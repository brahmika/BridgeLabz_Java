
// Compare two strings using charAt() and validate with String.equals()

import java.util.Scanner;

public class Person {

    public static boolean compareStringCharAt(String s1, String s2) {
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

        String s1 = sc.next();
        String s2 = sc.next();

        boolean charAtResult = compareStringCharAt(s1, s2);

        if (charAtResult) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        sc.close();
    }
}
