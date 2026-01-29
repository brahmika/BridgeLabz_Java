import java.util.Scanner;

public class L201 {
    public static int[] findFactor(int n){
        //find  factors of n
        // return factors as an array
        int count = 0;

        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;

        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                factors[index] = i;
                index++; 
            }
        }
        return factors;

    }
    public static int findSum(int[] factors){
        //find sum of the factors from the array output before
        int sum = 0;
        for (int i = 0; i < factors.length; i++){
            sum = sum + factors[i];
        }
        return sum;
    }
    public static double sumSquare(int[] factors){
        //find sum of squares
        double sum = 0;
        for (int i = 0; i < factors.length; i++){
            double square = Math.pow(factors[i], 2);
            sum = sum + square;
        }
        return sum;
    }
    public static double productFactors(int[] factors){
        double product = 1;
        for (int i = 0; i < factors.length; i++){
            product = product * factors[i];
        }
        return product;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] factor = findFactor(num);
        System.out.println("Factors:");
        for (int f = 0; f < factor.length; f++){
            System.out.println(factor[f] + " ");
        }
        System.out.println();
        int finalSum = findSum(factor);
        double square = sumSquare(factor);
        double products = productFactors(factor);
        System.out.println(finalSum);
        System.out.println(square);
        System.out.println(products);
    }
}
