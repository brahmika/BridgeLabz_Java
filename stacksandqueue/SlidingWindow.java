package stacksandqueue;

/*
    Goal of this class:
    This class finds the maximum element in every contiguous subarray
    (sliding window) of size k from a given integer array. A custom
    double-ended queue (deque) is implemented using an array to store
    indices of useful elements, ensuring that each window's maximum
    can be determined efficiently.
*/

public class SlidingWindow {

    static int[] deque = new int[50];
    static int front = 0;
    static int rear = -1;

    // Adds an index to the rear of the deque
    static void addRear(int index) {
        deque[++rear] = index;
    }

    // Removes an index from the rear of the deque
    static void removeRear() {
        rear--;
    }

    // Removes an index from the front of the deque
    static void removeFront() {
        front++;
    }

    // Returns the front index of the deque
    static int getFront() {
        return deque[front];
    }

    // Checks whether the deque is empty
    static boolean isEmpty() {
        return front > rear;
    }

    // Computes and prints maximum values for each sliding window
    static void slidingWindowMax(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {

            if (!isEmpty() && getFront() <= i - k) {
                removeFront();
            }

            while (!isEmpty() && arr[deque[rear]] <= arr[i]) {
                removeRear();
            }

            addRear(i);

            if (i >= k - 1) {
                System.out.print(arr[getFront()] + " ");
            }
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        slidingWindowMax(arr, k);
    }
}
