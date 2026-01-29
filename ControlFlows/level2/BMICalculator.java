// Calculates BMI and determines weight category.

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight in kilograms: ");
        double weight = sc.nextDouble();

        System.out.print("Enter height in meters: ");
        double height = sc.nextDouble();

        if (weight > 0 && height > 0) {
            double bmi = weight / (height * height);

            System.out.println("Your BMI is: " + bmi);

            if (bmi < 18.5) {
                System.out.println("Category: Underweight");
            } else if (bmi >= 18.5 && bmi < 24.9) {
                System.out.println("Category: Normal weight");
            } else if (bmi >= 25 && bmi < 29.9) {
                System.out.println("Category: Overweight");
            } else {
                System.out.println("Category: Obese");
            }
        } else {
            System.out.println("Please enter valid weight and height values.");
        }
    }
}
