// Performs multiple digit-based checks and computations on numbers using static methods.

public class NumberChecker1 {

    public static int countDigits(int number) {
        int count = 0;
        int temp = number;
        while (temp > 0) {
            count++;
            temp = temp / 10;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += Math.pow(digits[i], 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
            freq[i][1] = 0;
        }

        for (int i = 0; i < digits.length; i++) {
            freq[digits[i]][1]++;
        }

        return freq;
    }

    public static void main(String[] args) {
        int number = 21;

        int[] digits = storeDigits(number);

        System.out.println(countDigits(number));
        System.out.println(sumOfDigits(digits));
        System.out.println(sumOfSquaresOfDigits(digits));
        System.out.println(isHarshadNumber(number, digits));

        int[][] freq = digitFrequency(digits);

        for (int i = 0; i < freq.length; i++) {
            if (freq[i][1] > 0) {
                System.out.println(freq[i][0] + " " + freq[i][1]);
            }
        }
    }
}
