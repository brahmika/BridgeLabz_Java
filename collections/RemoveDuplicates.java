package collections;
/*
 * This program removes duplicate elements from a given list
 * while preserving the original order of elements.
 * It uses a LinkedHashSet to automatically eliminate duplicates
 * and maintain insertion order, then updates the list with unique values.
 */
import java.util.*;
public class RemoveDuplicates {

    // Removes duplicates from the given list while preserving order
    public static void removeDuplicates(List<Integer> list) {

        Set<Integer> uniqueSet = new LinkedHashSet<>(list);

        list.clear();          // Clear original list
        list.addAll(uniqueSet); // Add back unique elements
    }

    // Entry point of the program to test duplicate removal
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        System.out.println("Before Removing Duplicates: " + numbers);

        removeDuplicates(numbers);

        System.out.println("After Removing Duplicates:  " + numbers);
    }
}
