/*
 * This program finds the symmetric difference of two sets.
 * The symmetric difference contains elements that are present
 * in either of the sets but not in both.
 * It is computed by combining both sets and removing
 * the elements that appear in their intersection.
 */
package collections;

import java.util.HashSet;
import java.util.Set;
public class SymmetricDifference {

    // Returns the symmetric difference of two sets
    public static Set<Integer> findSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {

        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2); // Union of both sets

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // Common elements

        result.removeAll(intersection); // Remove common elements

        return result;
    }

    // Entry point of the program to test symmetric difference
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> symmetricDifference = findSymmetricDifference(set1, set2);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}
