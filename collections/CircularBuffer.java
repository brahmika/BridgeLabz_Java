/*
 * This program simulates a circular buffer using an array-based queue.
 * The buffer has a fixed size. When it becomes full and a new element
 * is inserted, the oldest element is automatically overwritten.
 * The front pointer always indicates the oldest element,
 * and elements are inserted using circular indexing.
 */
package collections;

public class CircularBuffer {

    private int[] buffer;
    private int capacity;
    private int front = 0;
    private int size = 0;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }

    // Inserts an element into the circular buffer
    public void insert(int value) {

        int rear = (front + size) % capacity;
        buffer[rear] = value;

        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity; // Overwrite oldest
        }
    }

    // Displays the current elements in the buffer
    public void display() {

        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(buffer[index]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Entry point of the program to test circular buffer
    public static void main(String[] args) {

        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();

        cb.insert(4);  // Overwrites 1
        cb.display();
    }
}
