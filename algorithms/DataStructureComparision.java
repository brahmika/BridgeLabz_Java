/*
 * Compares searching performance of Array (O(N)),
 * HashSet (O(1)), and TreeSet (O(log N)).
 */

package algorithms;
import java.util.*;
public class DataStructureComparision {
    public static void main(String[] args) {

        int size = 1_000_000;   // Change size to test performance
        int target = size - 1;  // Element to search

        // Create and fill Array
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        // Create and fill HashSet
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            hashSet.add(i);
        }

        // Create and fill TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            treeSet.add(i);
        }

        // Array Linear Search (O(N))
        long startArray = System.currentTimeMillis();
        boolean foundArray = false;
        for (int value : array) {
            if (value == target) {
                foundArray = true;
                break;
            }
        }
        long endArray = System.currentTimeMillis();

        // HashSet Search (O(1) average)
        long startHash = System.currentTimeMillis();
        boolean foundHash = hashSet.contains(target);
        long endHash = System.currentTimeMillis();

        // TreeSet Search (O(log N))
        long startTree = System.currentTimeMillis();
        boolean foundTree = treeSet.contains(target);
        long endTree = System.currentTimeMillis();

        // Display results
        System.out.println("Dataset Size: " + size);
        System.out.println("Array Search Time (ms): " + (endArray - startArray));
        System.out.println("HashSet Search Time (ms): " + (endHash - startHash));
        System.out.println("TreeSet Search Time (ms): " + (endTree - startTree));
    }
}
