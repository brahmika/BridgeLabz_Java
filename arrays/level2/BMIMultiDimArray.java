// Calculates BMI for multiple persons using a 2D array to store height, weight, and BMI.

import java.util.Scanner;

public class BMIMultiDimArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; // 0 -> weight, 1 -> height, 2 -> BMI
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            double weight, height;

            while (true) {
                System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
                weight = sc.nextDouble();
                if (weight > 0) break;
                System.out.println("Weight must be positive. Enter again.");
            }

            while (true) {
                System.out.print("Enter height (m) of person " + (i + 1) + ": ");
                height = sc.nextDouble();
                if (height > 0) break;
                System.out.println("Height must be positive. Enter again.");
            }

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height);

            double bmi = personData[i][2];
            if (bmi < 18.5) weightStatus[i] = "Underweight";
            else if (bmi < 24.9) weightStatus[i] = "Normal weight";
            else if (bmi < 29.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        System.out.println("\nPerson\tWeight(kg)\tHeight(m)\tBMI\t\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s\n", 
                i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
