/*
 * Uses binary search to find the index of the smallest element in a rotated array.
 * Returns the rotation point index in O(log n) time.
 */

package linearsearch;

public class RotationPoint {
    public static int findSmallestIndex(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                // Smallest element is in right half
                left = mid + 1;
            } else {
                // Smallest element is in left half (including mid)
                right = mid;
            }
        }

        return left;   // Index of smallest element
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        int index = findSmallestIndex(arr);

        System.out.println("Rotation point index: " + index);
        System.out.println("Smallest element: " + arr[index]);
    }
}
