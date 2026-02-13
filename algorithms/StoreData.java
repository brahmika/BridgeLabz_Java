/*
 * Compares Bubble Sort (O(N²)), Merge Sort (O(N log N)),
 * and Quick Sort (O(N log N)) for different dataset sizes.
 */
package algorithms;
import java.util.Random;

public class StoreData {
    //bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++)
            arr[left + p] = temp[p];
    }

    //Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Main Method
    public static void main(String[] args) {

        int size = 10000;   // Change to 1000, 10000, 100000 (Avoid 1M for Bubble Sort)
        int[] original = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            original[i] = rand.nextInt(size);
        }

        // Bubble Sort
        int[] arr1 = original.clone();
        long startBubble = System.nanoTime();
        bubbleSort(arr1);
        long endBubble = System.nanoTime();

        // Merge Sort
        int[] arr2 = original.clone();
        long startMerge = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        long endMerge = System.nanoTime();

        // Quick Sort
        int[] arr3 = original.clone();
        long startQuick = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        long endQuick = System.nanoTime();

        // Results
        System.out.println("Dataset Size: " + size);
        System.out.println("Bubble Sort Time (ms): " + (endBubble - startBubble) / 1_000_000);
        System.out.println("Merge Sort Time (ms): " + (endMerge - startMerge) / 1_000_000);
        System.out.println("Quick Sort Time (ms): " + (endQuick - startQuick) / 1_000_000);
    }
}
