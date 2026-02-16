package collections;

import java.util.LinkedList;
import java.util.Queue;

/*
 * This program implements a Stack using two Queues.
 * Since a stack follows LIFO and a queue follows FIFO,
 * we simulate stack behavior by rearranging elements
 * during the push operation so that the most recently
 * added element always stays at the front of the main queue.
 */

public class StackUsingQueues {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Pushes an element onto the stack
    public void push(int value) {

        q2.add(value);  // Add new element to q2

        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes and returns the top element of the stack
    public int pop() {

        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return q1.remove();
    }

    // Returns the top element without removing it
    public int top() {

        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return q1.peek();
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Entry point of the program to test stack operations
    public static void main(String[] args) {

        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top after pop: " + stack.top());
    }
}
