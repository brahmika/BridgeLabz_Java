/*
 * Removes duplicate characters while preserving original order.
 * Uses HashSet to track seen characters and StringBuilder to build result.
 */


package linearsearch;
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args){

        String input = "programming";

        StringBuilder result = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);

            if(!set.contains(ch)) {
                set.add(ch);
                result.append(ch);
            }
        }
        System.out.println("Oringinal String: " + input);
        System.out.println("Without Duplicates: " + result.toString());
    }
}
