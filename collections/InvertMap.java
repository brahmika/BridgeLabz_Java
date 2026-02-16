
/*
 * This program inverts a Map<K, V> into a Map<V, List<K>>.
 * If multiple keys share the same value, those keys are stored
 * together in a list. The program iterates through the original
 * map and builds the inverted map by grouping keys based on values.
 */
package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class InvertMap {

    // Inverts the given map and groups duplicate values into a list of keys
    public static <K, V> Map<V, List<K>> invert(Map<K, V> originalMap) {

        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {

            K key = entry.getKey();
            V value = entry.getValue();

            invertedMap
                    .computeIfAbsent(value, v -> new ArrayList<>())
                    .add(key);
        }

        return invertedMap;
    }

    // Entry point of the program to test map inversion
    public static void main(String[] args) {

        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        Map<Integer, List<String>> result = invert(inputMap);

        System.out.println("Original Map: " + inputMap);
        System.out.println("Inverted Map: " + result);
    }
}

