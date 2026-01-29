// Computes the number of rounds needed to run 5 km based on triangle perimeter.

import java.util.Scanner;

public class AthleteRoundsCalculator {
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
