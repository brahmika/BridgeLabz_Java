package collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 * This program reverses the elements of a queue using only queue operations.
 * Since a queue follows FIFO order, we use recursion to remove elements
 * from the front and add them back after the recursive calls finish.
 * This naturally reverses the order without using any additional data structures.
 */

public class ReverseQueue {

    // Reverses the given queue using recursion and queue operations only
    public static void reverseQueue(Queue<Integer> queue) {

        if (queue.isEmpty()) {
            return;
        }

        int front = queue.remove();   // Remove front element
        reverseQueue(queue);          // Recursively reverse remaining queue
        queue.add(front);             // Add removed element at rear
    }

    // Entry point of the program to test queue reversal
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Before Reversal: " + queue);

        reverseQueue(queue);

        System.out.println("After Reversal:  " + queue);
    }
}
