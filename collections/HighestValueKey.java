/*
 * This program finds the key with the highest value in a Map<String, Integer>.
 * It iterates through all entries in the map and keeps track of the maximum
 * value found so far along with its corresponding key.
 */

package collections;

import java.util.HashMap;
import java.util.Map;

public class HighestValueKey {

    // Returns the key that has the maximum value in the map
    public static String findMaxKey(Map<String, Integer> map) {

        if (map == null || map.isEmpty()) {
            return null;
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    // Entry point of the program to test finding the max value key
    public static void main(String[] args) {

        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        String result = findMaxKey(inputMap);

        System.out.println("Input Map: " + inputMap);
        System.out.println("Key with Highest Value: " + result);
    }
}
