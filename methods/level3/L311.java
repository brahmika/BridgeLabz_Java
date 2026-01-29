public class L311 {

    public static int[][] generateEmployeeData(int n) {
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = (int)(Math.random() * 90000) + 10000;
            data[i][1] = (int)(Math.random() * 10) + 1;
        }
        return data;
    }

    public static double[][] calculateBonus(int[][] data) {
        double[][] result = new double[data.length][2];
        for (int i = 0; i < data.length; i++) {
            double rate = data[i][1] > 5 ? 0.05 : 0.02;
            result[i][0] = data[i][0] + (data[i][0] * rate);
            result[i][1] = data[i][0] * rate;
        }
        return result;
    }

    public static void displaySummary(int[][] oldData, double[][] newData) {
        double oldSum = 0, newSum = 0, bonusSum = 0;
        for (int i = 0; i < oldData.length; i++) {
            oldSum += oldData[i][0];
            newSum += newData[i][0];
            bonusSum += newData[i][1];
            System.out.println(oldData[i][0] + "\t" + newData[i][1] + "\t" + newData[i][0]);
        }
        System.out.println(oldSum);
        System.out.println(newSum);
        System.out.println(bonusSum);
    }

    public static void main(String[] args) {
        int[][] data = generateEmployeeData(10);
        double[][] result = calculateBonus(data);
        displaySummary(data, result);
    }
}
