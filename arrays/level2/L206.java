import java.util.Scanner;

class L206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter height (m) of person " + (i + 1) + ": ");
            height[i] = sc.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 24.9) {
                status[i] = "Normal weight";
            } else if (bmi[i] < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        System.out.println("\nPerson\tHeight(m)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s\n", i + 1, height[i], weight[i], bmi[i], status[i]);
        }
    }
}
