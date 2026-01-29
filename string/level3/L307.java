import java.util.Scanner;

class L307 {

    // Approach 1: Iterative
    static boolean isPalindromeIterative(String text) {
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (RuntimeException e) {
        }

        int start = 0, end = len - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Approach 2: Recursive
    static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Approach 3: Using character arrays
    static boolean isPalindromeCharArray(String text) {
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (RuntimeException e) {
        }

        char[] original = new char[len];
        char[] reversed = new char[len];

        for (int i = 0; i < len; i++) {
            original[i] = text.charAt(i);
            reversed[len - 1 - i] = text.charAt(i);
        }

        for (int i = 0; i < len; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        System.out.println("Iterative check: " + (isPalindromeIterative(input) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive check: " + (isPalindromeRecursive(input, 0, input.length() - 1) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Char array check: " + (isPalindromeCharArray(input) ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}
