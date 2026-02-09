package stacksandqueue;

/*
    Goal of this class:
    This class demonstrates how a stack can be sorted in ascending order
    using recursion instead of loops or built-in stack utilities.
    A custom stack is implemented using an array, and recursive logic
    is applied to remove elements one by one and insert them back into
    their correct sorted positions. The solution highlights how the
    function call stack itself can be used as a temporary storage
    mechanism while performing sorting operations.
*/

public class SortStack { // Class declaration

    static int[] stack = new int[10]; // Array to represent stack
    static int top = -1; // Variable to track top of stack

    static void push(int value) { // Method to push element
        stack[++top] = value; // Increment top and insert value
    }

    static int pop() { // Method to pop element
        return stack[top--]; // Return top element and decrement top
    }

    static boolean isEmpty() { // Method to check if stack is empty
        return top == -1; // Return true if stack is empty
    }

    static int peek() { // Method to view top element
        return stack[top]; // Return top element
    }

    static void sortStack() { // Method to sort stack recursively
        if (isEmpty()) { // Base case for recursion
            return; // Stop recursion
        }

        int temp = pop(); // Remove top element
        sortStack(); // Recursively sort remaining stack
        insertSorted(temp); // Insert element at correct position
    }

    static void insertSorted(int value) { // Method to insert element in sorted order
        if (isEmpty() || peek() <= value) { // Check if position is correct
            push(value); // Insert value into stack
            return; // Exit method
        }

        int temp = pop(); // Temporarily remove top element
        insertSorted(value); // Recursively find correct position
        push(temp); // Restore removed element
    }

    static void printStack() { // Method to print stack elements
        for (int i = 0; i <= top; i++) { // Traverse stack
            System.out.print(stack[i] + " "); // Print each element
        }
        System.out.println(); // Move to next line
    }

    public static void main(String[] args) { // Main method
        push(3); // Push element 3
        push(1); // Push element 1
        push(4); // Push element 4
        push(2); // Push element 2

        sortStack(); // Sort the stack

        printStack(); // Display sorted stack
    }
}

