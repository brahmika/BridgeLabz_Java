// Return characters of string using method vs toCharArray() and compare

import java.util.Scanner;

public class Circle  {

    public static char[] getCharsManual(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();

        char[] manualChars = getCharsManual(text);
        char[] builtInChars = text.toCharArray();

        boolean result = compareCharArrays(manualChars, builtInChars);

        for (char c : manualChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        for (char c : builtInChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        if (result) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        sc.close();
    }
}
