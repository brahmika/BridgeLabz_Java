/*
 * This method finds the first missing positive integer in the array.
 *
 * It works by marking the presence of numbers using index mapping.
 * For every number between 1 and n (array length),
 * we mark the corresponding index as negative. */
package linearsearch;

public class FirstNegativeNumber {
    public static int LinearSearch(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] < 0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){

        int[] numbers = {5, 8, 12, -3, 7, -10};

        int result = LinearSearch(numbers);
        if(result != -1) {
            System.out.println("First negative number found at index: " + result);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
}
