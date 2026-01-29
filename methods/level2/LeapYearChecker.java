// Checks whether a given year is a leap year using a method with Gregorian calendar rules.

import java.util.Scanner;

public class LeapYearChecker {
    public static boolean leapYear(int year){
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 ==0)){
            return true;
        } else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if(year < 1582){
            System.out.println("Not valid");
        }
        if (leapYear(year)) {
            System.out.println("Year is a Leap Year");
        } else {
            System.out.println("Year is not a Leap Year");
        }
        sc.close();
    }
}
