// Using charAt() to find frequencies

import java.util.Scanner;

public class StudentVoteChecker {

    static String[][] charFrequency(String text) {
        int[] freq = new int[256]; // ASCII frequencies
        int len = 0;

        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (RuntimeException e) {
        }

        // Count frequency
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count number of unique characters
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) count++;
        }

        // Store characters and their frequencies
        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = String.valueOf((char) i);
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

        String[][] freqData = charFrequency(input);
        displayFrequency(freqData);

        sc.close();
    }
}
