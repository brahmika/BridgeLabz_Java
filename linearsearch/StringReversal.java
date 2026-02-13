/*
 * Uses StringBuilder to reverse a given string.
 * Applies reverse() method and returns the reversed result.
 */

package linearsearch;

public class StringReversal {
    public static void main(String[] args){
        String input = "hello";

        StringBuilder sb = new StringBuilder();

        sb.append(input);

        sb.reverse();

        String reserved = sb.toString();

        System.out.println("Original String: "+ input);
        System.out.println("Reserved String: "+reserved);
    }
}

