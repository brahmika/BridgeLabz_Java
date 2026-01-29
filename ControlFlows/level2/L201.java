// Checks whether a given year is a leap year using multiple if-else conditions.

import java.util.Scanner;

class L201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (year < 1582) {
            System.out.println("Year must be 1582 or later (Gregorian calendar)");
            return;
        }

        System.out.println("Using multiple if-else:");

        if (year % 400 == 0) {
            System.out.println("The year is a Leap Year");
        } else if (year % 100 == 0) {
            System.out.println("The year is not a Leap Year");
        } else if (year % 4 == 0) {
            System.out.println("The year is a Leap Year");
        } else {
            System.out.println("The year is not a Leap Year");
        }

        System.out.println("Using single if condition:");

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("The year is a Leap Year");
        } else {
            System.out.println("The year is not a Leap Year");
        }
    }
}
