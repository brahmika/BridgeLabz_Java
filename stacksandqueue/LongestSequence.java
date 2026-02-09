package stacksandqueue;

/*
    Goal of this class:
    This class determines the length of the longest sequence of consecutive
    integers present in an unsorted array. A hash-based data structure is
    used to store elements for constant-time lookups, allowing efficient
    detection of sequence starting points and expansion of consecutive
    sequences without sorting the array.
*/

import java.util.*;

public class LongestSequence {

    // Finds the length of the longest consecutive sequence in the array
    static int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;

        for (int num : arr) {
            set.add(num);
        }

        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(arr));
    }
}
