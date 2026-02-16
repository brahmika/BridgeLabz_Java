/*
 * This program checks whether one set is a subset of another.
 * A set is considered a subset if every element of the first set
 * is present in the second set. The program iterates through
 * the first set and verifies that each element exists in the second set.
 */
package collections;

import java.util.HashSet;
import java.util.Set;


public class FindSubsets {

    // Returns true if set1 is a subset of set2 without using containsAll()
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {

        for (Integer element : set1) {
            if (!set2.contains(element)) {
                return false;
            }
        }
        return true;
    }

    // Entry point of the program to test subset checking
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        boolean result = isSubset(set1, set2);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Is Set1 a subset of Set2? " + result);
    }
}
