package collections;
import java.util.*;


public class ReverseList {
    public static void reverseList(List<Integer> list){
        int start = 0;
        int end = list.size() - 1;

        while(start < end){
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(4);

        System.out.println("ArrayList Before: " + arrayList);
        reverseList(arrayList);
        System.out.println("ArrayList After: " + arrayList);
    }
}
