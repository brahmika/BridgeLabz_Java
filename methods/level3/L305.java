public class L305 {

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sum = 0;
        while (square > 0) {
            sum = sum + (square % 10);
            square = square / 10;
        }
        return sum == number;
    }

    public static boolean isSpyNumber(int number) {
        int sum = 0;
        int product = 1;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum = sum + digit;
            product = product * digit;
            temp = temp / 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        int temp = number;

        while (temp > 0) {
            if (temp % 10 != square % 10) {
                return false;
            }
            temp = temp / 10;
            square = square / 10;
        }
        return true;
    }

    public static boolean isBuzzNumber(int number) {
        if (number % 7 == 0) {
            return true;
        }
        if (number % 10 == 7) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 7;

        System.out.println(isPrime(number));
        System.out.println(isNeonNumber(number));
        System.out.println(isSpyNumber(number));
        System.out.println(isAutomorphicNumber(number));
        System.out.println(isBuzzNumber(number));
    }
}
