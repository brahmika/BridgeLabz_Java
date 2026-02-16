package collections;
import java.util.HashMap;
import java.util.Map;

/*
 * This program merges two Map<String, Integer> objects.
 * If a key exists in both maps, their values are summed.
 * If a key exists in only one map, it is added directly
 * to the merged result map.
 */

public class MergeMaps {

    // Merges two maps and sums values of common keys
    public static Map<String, Integer> merge(Map<String, Integer> map1,
                                             Map<String, Integer> map2) {

        Map<String, Integer> mergedMap = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {

            String key = entry.getKey();
            Integer value = entry.getValue();

            mergedMap.put(key,
                    mergedMap.getOrDefault(key, 0) + value);
        }

        return mergedMap;
    }

    // Entry point of the program to test map merging
    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> result = merge(map1, map2);

        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);
        System.out.println("Merged Map: " + result);
    }
}
