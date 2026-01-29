// Divides N chocolates among M children and returns quotient and remainder using a method.

import java.util.Scanner;

public class ChocolatesDivider {
    public static int[] Division(int n, int divisor){
        int reminder = n/divisor;
        int quoitent = n % divisor;
        return new int[]{reminder, quoitent};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int num2 = sc.nextInt();
        int[] ans = Division(num, num2);

        System.out.println(ans);

        sc.close();
    }
}
