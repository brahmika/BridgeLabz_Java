// Converts height from centimeters to feet and inches.

import java.util.Scanner;
public class HeightConverter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your height in cm: ");
        double height = sc.nextDouble();
        double totalInches = height / 2.54;
        int feet = (int)(totalInches / 12);
        double inches = totalInches % 12;

        System.out.println(feet);
        System.out.println(inches);
    }
}
