/*
 * Reads a file and counts occurrences of a specific word.
 * Splits each line into words and increments a counter.
 */

package linearsearch;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WordOccurance {

    public static void main(String[] args) {

        String targetWord = "is";
        FileReader fr = null;
        BufferedReader br = null;
        int count = 0;

        try {
            fr = new FileReader("C:\\Users\\brahmika\\Desktop\\BridgeLabz_Java\\linearsearch\\Sample.txt");
            br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {

                String word = "";

                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    if (Character.isLetterOrDigit(ch)) {
                        word += ch;
                    } else {
                        if (word.length() > 0) {
                            if (word.equalsIgnoreCase(targetWord)) {
                                count++;
                            }
                            word = "";
                        }
                    }
                }

                if (word.length() > 0) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Word count: " + count);
    }
}
