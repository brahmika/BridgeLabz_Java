/*
 * This program reads a text file and counts the frequency of each word
 * using a HashMap. It ignores case differences and removes punctuation
 * so that words like "Hello" and "hello," are treated as the same word.
 * Each cleaned word is stored as a key in the map, and its occurrence
 * count is updated as the file is processed.
 */
package collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class WordFrequency {


    // Reads a file and returns a map containing word frequencies
    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {

        Map<String, Integer> frequencyMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;

        while ((line = reader.readLine()) != null) {

            line = line.toLowerCase();                   // Convert to lowercase
            line = line.replaceAll("[^a-z0-9\\s]", ""); // Remove punctuation

            String[] words = line.split("\\s+");        // Split by whitespace

            for (String word : words) {
                if (!word.isEmpty()) {
                    frequencyMap.put(word,
                            frequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        reader.close();
        return frequencyMap;
    }

    // Entry point of the program to test word frequency counting
    public static void main(String[] args) {

        try {
            String filePath = "input.txt";  // Replace with your file path
            Map<String, Integer> result = countWordFrequency(filePath);

            System.out.println("Word Frequencies: " + result);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
