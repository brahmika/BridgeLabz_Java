package sorting;/*
 * Program: Bubble Sort in Java
 * Description:
 * This program sorts an array of integers using the Bubble Sort algorithm.
 * Bubble Sort works by repeatedly comparing adjacent elements and swapping
 * them if they are in the wrong order. After each pass, the largest element
 * moves (bubbles) to the end of the array.
 */

public class StudentMarks {

    // Method to sort the array using Bubble Sort
    public static int[] bubbleSort(int[] arr) {

        int size = arr.length; // Store the length of the array

        // Outer loop controls the number of passes
        for (int i = 0; i < size - 1; i++) {

            // Inner loop compares adjacent elements
            for (int j = 0; j < size - i - 1; j++) {

                // Check if current element is greater than the next element
                if (arr[j] > arr[j + 1]) {

                    // Store the current element temporarily
                    int temp = arr[j];

                    // Move the smaller element to the left
                    arr[j] = arr[j + 1];

                    // Place the larger element to the right
                    arr[j + 1] = temp;
                }
            }
        }

        // Return the sorted array
        return arr;
    }

    // Main method: program execution starts here
    public static void main(String[] args) {

        // Initialize the array with unsorted values
        int[] arr = {2, 3, 5, 1, 7, 8};

        // Call bubbleSort method to sort the array
        int[] sorted = bubbleSort(arr);

        // Print the sorted array
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
}
