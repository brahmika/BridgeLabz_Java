// Write a program to check if a number is divisible by 5
import java.util.Scanner;
public class DivisibleByFive {
    public static void main(String[] args){
        try (Scanner input = new Scanner(System.in)) {
            int num = input.nextInt();
            if (num % 5 == 0) {
                System.out.println(num + " is divisible by 5");
            } else{
                System.out.println(num + " is not divisible by 5");
            }
        }
    }
}