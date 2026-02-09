package stacksandqueue;

/*
    Goal of this class:
    This class solves the Two Sum problem by identifying two indices in
    an integer array such that the values at those indices add up to a
    specified target sum. A hash map is used to store elements along with
    their indices as the array is traversed, enabling efficient lookup
    of the complementary value required to reach the target.
*/

import java.util.*;

public class TwoSum {

    // Finds and returns indices of two elements whose sum equals the target
    static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            }
            map.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);

        System.out.println(result[0] + " " + result[1]);
    }
}
