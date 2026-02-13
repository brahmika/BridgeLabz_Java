/*
 * Iterates through sentences to find the first one containing the given word.
 * Returns the sentence if found, otherwise returns "Not Found".
 */

package linearsearch;

public class SearchWord {

    public static String searchSentence(String[] sentences, String word) {

        for (int i = 0; i < sentences.length; i++) {

            if (sentences[i].contains(word)) {
                return sentences[i];   // Stop immediately when found
            }

        }

        return "Not Found";   // If no sentence contains the word
    }

    public static void main(String[] args) {

        String[] sentences = {
                "Java is a programming language",
                "Python is very popular",
                "I love learning new technologies",
                "Linear search is simple"
        };

        String wordToSearch = "Python";

        String result = searchSentence(sentences, wordToSearch);

        System.out.println(result);
    }
}
