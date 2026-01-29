// Checks if a number is positive, negative, or zero using a method.

import java.util.Scanner;

public class NumberSignChecker {

    public static int checkRounds(int a, int b, int c){
        int perimeter = a + b + c;
        int noOfRounds = perimeter/5;
        return noOfRounds;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int side1 = sc.nextInt();
        int side2 = sc.nextInt();
        int side3 = sc.nextInt();

        int rounds = checkRounds(side1, side2, side3);
        System.out.println(rounds);

        sc.close();
    }
}
