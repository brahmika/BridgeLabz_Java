// Outer loop for each char, inner loop for counting duplicates

import java.util.Scanner;

public class NumberAnalysis {

    static String[][] frequencyNestedLoops(String text) {
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (RuntimeException e) {
        }

        char[] chars = new char[len];
        int[] freq = new int[len];

        for (int i = 0; i < len; i++) {
            chars[i] = text.charAt(i);
            freq[i] = 1;
        }

        // Nested loop to count frequency
        for (int i = 0; i < len; i++) {
            if (chars[i] == '0') continue; // already counted
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark counted
                }
            }
        }

        // Count number of unique characters
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') count++;
        }

        // Store result
        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                result[index][0] = String.valueOf(chars[i]);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }

        return result;
    }

    static void displayFrequency(String[][] freqData) {
        System.out.println("Character\tFrequency");
        for (int i = 0; i < freqData.length; i++) {
            System.out.println(freqData[i][0] + "\t\t" + freqData[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[][] freqData = frequencyNestedLoops(input);
        displayFrequency(freqData);

        sc.close();
    }
}
