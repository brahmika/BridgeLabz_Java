
import java.util.Scanner;

class L208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int number = sc.nextInt();

        int[][] marks = new int[number][3]; // 0 -> Physics, 1 -> Chemistry, 2 -> Maths
        double[] percentage = new double[number];
        String[] grade = new String[number];

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < 3; j++) {
                while (true) {
                    if (j == 0) System.out.print("Enter Physics marks for student " + (i + 1) + ": ");
                    else if (j == 1) System.out.print("Enter Chemistry marks for student " + (i + 1) + ": ");
                    else System.out.print("Enter Maths marks for student " + (i + 1) + ": ");

                    int mark = sc.nextInt();
                    if (mark >= 0) {
                        marks[i][j] = mark;
                        break;
                    } else {
                        System.out.println("Marks must be non-negative. Enter again.");
                    }
                }
            }

            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percentage[i] >= 90) grade[i] = "A";
            else if (percentage[i] >= 80) grade[i] = "B";
            else if (percentage[i] >= 70) grade[i] = "C";
            else if (percentage[i] >= 60) grade[i] = "D";
            else grade[i] = "F";
        }

        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < number; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.2f\t\t%s\n",
                    i + 1, marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }
    }
}

