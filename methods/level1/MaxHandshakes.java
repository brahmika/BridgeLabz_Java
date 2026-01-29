// Computes maximum number of handshakes among N students using combination formula.

import java.util.Scanner;

public class MaxHandshakes {
    public static int handShakes(int n) {
        return (n * (n - 1)) / 2;
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of hands");
        int numberOfHands = sc.nextInt();

        int maxHands = handShakes(numberOfHands);

        System.out.println(maxHands);


        sc.close();
    
    }

}
