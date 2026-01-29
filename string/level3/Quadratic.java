// Check if two strings have same character frequencies

import java.util.Scanner;

public class Quadratic {

    static boolean areAnagrams(String text1, String text2) {
        // Find lengths
        int len1 = 0, len2 = 0;
        try {
            while (true) { text1.charAt(len1); len1++; }
        } catch (RuntimeException e) {}
        try {
            while (true) { text2.charAt(len2); len2++; }
        } catch (RuntimeException e) {}

        // If lengths are not equal, cannot be anagrams
        if (len1 != len2) return false;

        // Count frequency of each character
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < len1; i++) freq1[text1.charAt(i)]++;
        for (int i = 0; i < len2; i++) freq2[text2.charAt(i)]++;

        // Compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();
        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();

        boolean result = areAnagrams(text1, text2);
        if (result) System.out.println("The texts are anagrams.");
        else System.out.println("The texts are not anagrams.");

        sc.close();
    }
}
