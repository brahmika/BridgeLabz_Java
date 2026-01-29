// Trim leading/trailing spaces without trim() and compare results

import java.util.Scanner;

public class TrimSpaces {

    static int[] findTrimIndexes(String text) {

        int start = 0;
        int end = 0;

        try {
            while (text.charAt(start) == ' ') {
                start++;
            }
        } catch (RuntimeException e) {
        }

        try {
            end = start;
            while (true) {
                text.charAt(end);
                end++;
            }
        } catch (RuntimeException e) {
            end = end - 1;
        }

        try {
            while (text.charAt(end) == ' ') {
                end--;
            }
        } catch (RuntimeException e) {
        }

        return new int[]{start, end};
    }

    static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    static boolean compareStrings(String s1, String s2) {

        int i = 0;

        try {
            while (true) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return false;
                }
                i++;
            }
        } catch (RuntimeException e) {
        }

        try {
            s2.charAt(i);
            return false;
        } catch (RuntimeException e) {
            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        int[] indexes = findTrimIndexes(input);
        String userTrimmed = createSubstring(input, indexes[0], indexes[1]);

        String builtInTrimmed = input.trim();

        boolean result = compareStrings(userTrimmed, builtInTrimmed);

        System.out.println("User-defined Trimmed Text: [" + userTrimmed + "]");
        System.out.println("Built-in Trimmed Text: [" + builtInTrimmed + "]");
        System.out.println("Comparison Result: " + result);

        sc.close();
    }
}
