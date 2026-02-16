package collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
public class BinaryNumbers {
/*
 * This program generates the first N binary numbers using a queue.
 * It starts with "1" in the queue and repeatedly removes the front element,
 * adds it to the result list, and then enqueues two new binary numbers
 * by appending "0" and "1" to the removed element.
 * This approach ensures binary numbers are generated in sequence.
 */

    // Generates and returns the first N binary numbers as a list of strings
    public static List<String> generateBinary(int n) {

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        if (n <= 0) {
            return result;
        }

        queue.add("1");

        for (int i = 0; i < n; i++) {

            String current = queue.remove();  // Remove front binary number
            result.add(current);              // Add it to result

            queue.add(current + "0");         // Append 0 and enqueue
            queue.add(current + "1");         // Append 1 and enqueue
        }

        return result;
    }

    // Entry point of the program to test binary generation
    public static void main(String[] args) {

        int n = 5;

        List<String> binaryNumbers = generateBinary(n);

        System.out.println("First " + n + " Binary Numbers: " + binaryNumbers);
    }
}
