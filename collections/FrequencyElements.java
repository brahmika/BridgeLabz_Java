/** This program calculates the frequency of each element in a given List of strings.
        * It uses a HashMap to store each string as a key and its occurrence count as the value.
        * The list is traversed once, and for every element the count is updated in the map.
        * Finally, the map containing element frequencies is returned and printed.
package collections;
*/
package collections;
import java.util.*;
public class FrequencyElements {
    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args){
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Orange");

        Map<String, Integer> result = findFrequency(fruits);

        System.out.println(fruits);
        System.out.println(result);
    }
}
