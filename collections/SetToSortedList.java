/*
 * This program converts a HashSet of integers into a sorted List
 * in ascending order. Since a HashSet does not maintain order,
 * the elements are first added into an ArrayList and then sorted
 * using Collections.sort() to arrange them in increasing order.
 */
package collections;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SetToSortedList {

    // Converts a set into a sorted list in ascending order
    public static List<Integer> convertToSortedList(Set<Integer> set) {

        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        return sortedList;
    }

    // Entry point of the program to test set conversion and sorting
    public static void main(String[] args) {

        Set<Integer> numbers = new HashSet<>();
        numbers.add(5);
        numbers.add(3);
        numbers.add(9);
        numbers.add(1);

        List<Integer> result = convertToSortedList(numbers);

        System.out.println("Original Set: " + numbers);
        System.out.println("Sorted List:  " + result);
    }
}
