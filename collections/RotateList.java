/*
 * This program rotates the elements of a given list by a specified number of positions.
 * The first k elements are moved to the end of the list.
 * A temporary list is used to store elements in rotated order,
 * and then the original list is updated with those values.
 */
package collections;
import java.util.*;

public class RotateList {
    // Rotates the given list by k positions
    public static void rotateList(List<Integer> list, int k) {

        int n = list.size();
        k = k % n;  // Handles cases where k is greater than list size

        List<Integer> temp = new ArrayList<>();

        // Add elements from index k to end
        for (int i = k; i < n; i++) {
            temp.add(list.get(i));
        }

        // Add first k elements to the end
        for (int i = 0; i < k; i++) {
            temp.add(list.get(i));
        }

        // Copy rotated elements back to original list
        for (int i = 0; i < n; i++) {
            list.set(i, temp.get(i));
        }
    }

    // Entry point of the program to test rotation
public static void main(String[] args) {
     List<Integer> numbers = new ArrayList<>();
     numbers.add(10);
     numbers.add(20);
     numbers.add(30);
     numbers.add(40);
     numbers.add(50);

     System.out.println("Before Rotation: " + numbers);

     rotateList(numbers, 2);

     System.out.println("After Rotation:  " + numbers);
    }
}
