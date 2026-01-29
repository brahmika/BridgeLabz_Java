import java.util.Scanner;

public class L202 {
    public static int recursiveSum(int n){
        if(n == 1){
            return 1;
        }
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n){
        return n * (n + 1)/2;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int recursiveOfSum = recursiveSum(n);
        int sumByFormula = formulaSum(n);

        System.out.println(recursiveOfSum);
        System.out.println(sumByFormula);

        if (recursiveOfSum == sumByFormula){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        sc.close();
    }
}
