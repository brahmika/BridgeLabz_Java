/*
 * Compares performance of StringBuilder and StringBuffer for large concatenation.
 * Also compares FileReader and InputStreamReader for reading large files.
 */
package linearsearch;

import java.util.Arrays;

public class SearchChallenge {

    //
    public static int firstMissingPositive(int[] arr) {

        int n = arr.length;

        // Mark numbers in range 1 to n
        for (int i = 0; i < n; i++) {

            int value = Math.abs(arr[i]);

            if (value >= 1 && value <= n) {
                arr[value - 1] = -Math.abs(arr[value - 1]);
            }
        }

        // First positive index + 1 is missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    //Binary Search for Target
    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Main Method
    public static void main(String[] args) {

        int[] arr = {3, 4, -1, 1};

        // Copy array for missing positive (because marking modifies it)
        int[] copy = Arrays.copyOf(arr, arr.length);

        int missing = firstMissingPositive(copy);
        System.out.println("First Missing Positive: " + missing);

        // Sort for binary search
        Arrays.sort(arr);

        int target = 4;
        int index = binarySearch(arr, target);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Target Index: " + index);
    }
}
