/*
 * This program computes the union and intersection of two sets.
 * The union contains all unique elements from both sets,
 * while the intersection contains only the common elements.
 * Built-in Set methods addAll() and retainAll() are used
 * to perform these operations efficiently.
 */
package collections;
import java.util.HashSet;
import java.util.Set;

public class UnionIntersectionSet {

    // Returns the union of two sets
    public static Set<Integer> findUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    // Returns the intersection of two sets
    public static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }

    // Entry point of the program to test union and intersection
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> union = findUnion(set1, set2);
        Set<Integer> intersection = findIntersection(set1, set2);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}
