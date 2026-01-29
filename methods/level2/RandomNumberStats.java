// Generates 5 random 4-digit numbers and computes their average, minimum, and maximum using methods.

import java.util.Scanner;

public class RandomNumberStats {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightM = data[i][1] / 100;
            data[i][2] = weight / (heightM * heightM);
        }
    }

    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 24.9) {
                status[i] = "Normal";
            } else if (bmi < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] teamData = new double[10][3];

        for (int i = 0; i < 10; i++) {
            teamData[i][0] = sc.nextDouble();
            teamData[i][1] = sc.nextDouble();
        }

        calculateBMI(teamData);
        String[] status = getBMIStatus(teamData);

        System.out.println("Person\tWeight\tHeight\tBMI\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s\n",
                    (i + 1), teamData[i][0], teamData[i][1], teamData[i][2], status[i]);
        }

        sc.close();
    }
}
