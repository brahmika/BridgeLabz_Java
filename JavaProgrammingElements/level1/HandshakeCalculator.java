// Calculates the maximum number of handshakes among students.

import java.util.Scanner;
public class HandshakeCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int numberOfStudents = sc.nextInt();

        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        System.out.println("The maximum number of possible handshakes is " + handshakes);
    }
        
}
