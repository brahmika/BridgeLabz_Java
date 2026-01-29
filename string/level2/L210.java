import java.util.Scanner;

class L210 {

    static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = 50 + (int)(Math.random() * 51); // Physics 50-100
            scores[i][1] = 50 + (int)(Math.random() * 51); // Chemistry 50-100
            scores[i][2] = 50 + (int)(Math.random() * 51); // Maths 50-100
        }
        return scores;
    }

    static double[][] calculatePercentage(int[][] scores) {
        double[][] result = new double[scores.length][3]; // total, average, percentage
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double perc = (total * 100.0) / 300.0;
            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(perc * 100.0) / 100.0;
        }
        return result;
    }

    static String[] calculateGrades(double[][] percentages) {
        String[] grades = new String[percentages.length];
        for (int i = 0; i < percentages.length; i++) {
            double perc = percentages[i][2];
            if (perc >= 90) grades[i] = "A+";
            else if (perc >= 80) grades[i] = "A";
            else if (perc >= 70) grades[i] = "B+";
            else if (perc >= 60) grades[i] = "B";
            else if (perc >= 50) grades[i] = "C";
            else grades[i] = "F";
        }
        return grades;
    }

    static void displayScorecard(int[][] scores, double[][] percentages, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i+1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2]
                               + "\t" + (int)percentages[i][0] + "\t" + percentages[i][1] + "\t" + percentages[i][2]
                               + "\t\t" + grades[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        double[][] percentages = calculatePercentage(scores);
        String[] grades = calculateGrades(percentages);

        displayScorecard(scores, percentages, grades);

        sc.close();
    }
}
