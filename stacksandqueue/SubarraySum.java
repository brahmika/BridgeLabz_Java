package stacksandqueue;

/*
    Goal of this class:
    This class identifies and prints all subarrays within a given integer
    array whose elements sum to zero. It uses the concept of cumulative
    sum along with a hash map to track previously seen sums and their
    indices. Whenever the same cumulative sum appears more than once,
    the elements between those indices form a zero-sum subarray.
*/

import java.util.*;

public class SubarraySum {

    // Finds and prints all zero-sum subarrays
    static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        map.put(0, new ArrayList<>(List.of(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray: [" + (start + 1) + ", " + i + "]");
                }
            }

            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, -4, -2, -2};

        findZeroSumSubarrays(arr);
    }
}
