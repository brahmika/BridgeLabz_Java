// Converts weight from pounds to kilograms.

import java.util.Scanner;

public class WeightConverter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input for weight in pounds
        System.out.print("Enter weight in pounds: ");
        double weightInPounds = sc.nextDouble();

        // Conversion: 1 pound = 2.2 kg
        double weightInKg = weightInPounds / 2.2;

        System.out.println("The weight of the person in pound is " + weightInPounds +
                           " and in kg is " + weightInKg);
    }
}
