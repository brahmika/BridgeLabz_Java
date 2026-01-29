import java.util.Scanner;

class L1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0.0;
        double value;

        System.out.print("Enter a number (0 to stop): ");
        value = sc.nextDouble();

        while (value != 0) {
            total += value;

            System.out.print("Enter a number (0 to stop): ");
            value = sc.nextDouble();
        }

        System.out.println("The total sum is " + total);
    }
}
