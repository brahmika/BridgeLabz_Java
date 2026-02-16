/*
 * This program checks whether two sets contain the same elements
 * regardless of their order. Since sets do not allow duplicates
 * and do not maintain order, we can directly use the equals() method
 * to determine if both sets contain identical elements.
 */
package collections;
import java.util.HashSet;
import java.util.Set;
public class EqualSets{
    public class SetEqualityCheck {

        // Returns true if both sets contain the same elements
        public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
            return set1.equals(set2);
        }

        // Entry point of the program to test set comparison
        public static void main(String[] args) {

            Set<Integer> set1 = new HashSet<>();
            set1.add(1);
            set1.add(2);
            set1.add(3);

            Set<Integer> set2 = new HashSet<>();
            set2.add(3);
            set2.add(2);
            set2.add(1);

            boolean result = areSetsEqual(set1, set2);

            System.out.println("Set1: " + set1);
            System.out.println("Set2: " + set2);
            System.out.println("Are sets equal? " + result);
        }
    }
}