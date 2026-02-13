/*
 * Compares performance of Linear Search (O(N)) and Binary Search (O(log N)).
 * Shows Binary Search is faster for large datasets when data is sorted.
 */

package algorithms;
import java.util.Arrays;
import java.util.Random;

public class SearchData {

    //linear search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int size = 1_000_000;   // Change size: 1000, 10000, 1000000
        int[] data = new int[size];

        // Fill array with random numbers
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size);
        }

        int target = data[size - 1];

        long startLinear = System.nanoTime();
        linearSearch(data, target);
        long endLinear = System.nanoTime();
        long linearTime = endLinear - startLinear;

        Arrays.sort(data);  // Sorting required

        long startBinary = System.nanoTime();
        binarySearch(data, target);
        long endBinary = System.nanoTime();
        long binaryTime = endBinary - startBinary;

        System.out.println("Dataset Size: " + size);
        System.out.println("Linear Search Time (ns): " + linearTime);
        System.out.println("Binary Search Time (ns): " + binaryTime);
    }
}
