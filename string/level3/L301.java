import java.util.Scanner;

class L301 {

    static String[][] calculateBMI(double[][] hw) {
        String[][] result = new String[hw.length][4]; // weight, height, BMI, status

        for (int i = 0; i < hw.length; i++) {
            double weight = hw[i][0];
            double heightM = hw[i][1] / 100.0; // convert cm to meters
            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0; // round to 2 decimals
            String status;

            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 25) status = "Normal";
            else if (bmi < 30) status = "Overweight";
            else status = "Obese";

            result[i][0] = String.valueOf(weight);
            result[i][1] = String.valueOf(hw[i][1]);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }

        return result;
    }

    static void displayBMI(String[][] data) {
        System.out.println("Person\tWeight(kg)\tHeight(cm)\tBMI\tStatus");
        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + "\t" + data[i][0] + "\t\t" + data[i][1] + "\t\t" + data[i][2] + "\t" + data[i][3]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[][] hw = new double[10][2]; // 10 persons, weight and height

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight(kg) of person " + (i + 1) + ": ");
            hw[i][0] = sc.nextDouble();
            System.out.print("Enter height(cm) of person " + (i + 1) + ": ");
            hw[i][1] = sc.nextDouble();
        }

        String[][] bmiData = calculateBMI(hw);
        displayBMI(bmiData);

        sc.close();
    }
}
