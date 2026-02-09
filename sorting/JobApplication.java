package sorting;

/*
    Goal of this class:
    This class sorts job applicants' expected salary demands in ascending
    order using the Heap Sort algorithm. A Max Heap is constructed from
    the input array so that the largest salary can be repeatedly extracted
    and placed at the end of the array. The heap is then reheapified until
    all elements are sorted, demonstrating an efficient comparison-based
    sorting technique.
*/

public class JobApplication {

    // Sorts the array using heap sort
    static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // Maintains the max heap property for a subtree
    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] salaries = {45000, 60000, 52000, 75000, 48000};

        heapSort(salaries);

        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }
}

