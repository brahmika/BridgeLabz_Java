// Determines leap year using a single if condition with logical operators.

import java.util.Scanner;

public class LeapYearLogical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (year < 1582) {
            System.out.println("Year must be 1582 or later (Gregorian calendar)");
        }
        else if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("The year is a Leap Year");
        } else {
            System.out.println("The year is not a Leap Year");
        }
    }
}
