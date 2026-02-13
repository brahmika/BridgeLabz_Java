/*
 * Concatenates multiple strings efficiently using StringBuffer.
 * Uses append() method inside a loop and returns final string.
 */

package linearsearch;

public class ConcatenateStrings {
    public static void main(String[] args){

        String[] arr = {"Hello", "World", "Welcome","To", "Java"};
        String result = concatStrings(arr);
        System.out.println(result);
    }
    public static String concatStrings(String[] arr){
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
