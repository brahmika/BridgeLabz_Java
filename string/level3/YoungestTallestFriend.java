// Combine unique character logic and frequency calculation

import java.util.Scanner;

public class YoungestTallestFriend {

    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (RuntimeException e) {
        }
        return count;
    }

    static char[] uniqueCharacters(String text) {
        int len = findLength(text);
        char[] temp = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (ch == temp[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[index++] = ch;
            }
        }

        char[] unique = new char[index];
        for (int i = 0; i < index; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }

    static String[][] frequencyUsingUnique(String text) {
        char[] uniqueChars = uniqueCharacters(text);
        int len = findLength(text);

        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (text.charAt(j) == ch) count++;
            }
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(count);
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

        String[][] freqData = frequencyUsingUnique(input);
        displayFrequency(freqData);

        sc.close();
    }
}
