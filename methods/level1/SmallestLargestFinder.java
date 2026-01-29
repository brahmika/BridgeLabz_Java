// Finds smallest and largest of three numbers using a method returning an array.

import java.util.Scanner;

public class SmallestLargestFinder {
    public static int SumOfNatural(int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = sum + i;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int fullSum = SumOfNatural(num);

        System.out.println(fullSum);
    }
}
