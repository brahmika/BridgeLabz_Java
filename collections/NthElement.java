/*
 * This program finds the Nth element from the end of a singly linked list
 * without calculating the size of the list.
 * It uses two pointers: the first pointer moves N steps ahead,
 * and then both pointers move together until the first reaches the end.
 * The second pointer will then point to the desired element.
 */

package collections;
import java.util.*;
public class NthElement {
    // Returns the Nth element from the end of the linked list
    public static String findNthFromEnd(LinkedList<String> list, int n) {

        if (list == null || list.isEmpty() || n <= 0) {
            return null;
        }

        Iterator<String> first = list.iterator();
        Iterator<String> second = list.iterator();

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                return null; // If n is greater than list size
            }
            first.next();
        }

        // Move both pointers until first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }

    // Entry point of the program to test the method
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println("List: " + list);

        String result = findNthFromEnd(list, 2);

        System.out.println("Nth Element from End: " + result);
    }
}
