// Checks voting eligibility for 10 students using an array of ages.

import java.util.Scanner;

public class VotingEligibilityArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[10];

        for(int i = 0; i < ages.length; i++){
            System.out.println("Enter age of student" + (i + 1)+ ": ");
            ages[i] = sc.nextInt();
        }

        System.out.println();

        for (int i = 0; i < ages.length; i++){
            if(ages[i] < 0){
                System.out.println("Invalid Ages:" + ages[i]);
            } else if (ages[i] >= 18){
                System.out.println("Can Vote");
            } else {
                System.out.println("Cannot vote!");
            }
        }
    }
}
