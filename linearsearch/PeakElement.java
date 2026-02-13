/*
 * Uses binary search to find any peak element in the array.
 * Returns the index of an element greater than its neighbors.
 */

package linearsearch;

public class PeakElement {
    public static int findPeak(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            boolean leftOk = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightOk = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);

            // If both conditions are true → peak found
            if (leftOk && rightOk) {
                return mid;
            }

            // If left neighbor is greater → peak must be on left side
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Otherwise → peak must be on right side
            else {
                left = mid + 1;
            }
        }

        return -1; // Should never reach here if array is valid
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeak(arr);

        System.out.println("Peak element found at index: " + peakIndex);
        System.out.println("Peak value: " + arr[peakIndex]);
    }
}
