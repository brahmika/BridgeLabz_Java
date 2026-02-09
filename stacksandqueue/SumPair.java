package stacksandqueue;

/*
    Goal of this class:
    This class checks whether a given integer array contains a pair of
    elements whose sum is equal to a specified target value. It uses a
    hash map to store elements encountered so far and efficiently
    determines whether the complementary value required to reach the
    target sum already exists in the array.
*/

import java.util.*;

public class SumPair {

    // Checks if any pair in the array adds up to the target sum
    static boolean hasPairWithSum(int[] arr, int target) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : arr) {
            if (map.containsKey(target - num)) {
                return true;
            }
            map.put(num, true);
        }

        return false;
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;

        System.out.println(hasPairWithSum(arr, target));
    }
}
