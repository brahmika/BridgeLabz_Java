import java.util.Scanner;

public class L209 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input for the sides of the triangular park
        System.out.print("Enter side 1 of the triangle (in meters): ");
        double side1 = sc.nextDouble();

        System.out.print("Enter side 2 of the triangle (in meters): ");
        double side2 = sc.nextDouble();

        System.out.print("Enter side 3 of the triangle (in meters): ");
        double side3 = sc.nextDouble();

        // Perimeter of the triangle
        double perimeter = side1 + side2 + side3;

        // Total distance to run in meters (5 km = 5000 meters)
        double totalDistance = 5000;

        // Number of rounds needed
        double rounds = totalDistance / perimeter;

        System.out.println("The total number of rounds the athlete will run is " 
                           + rounds + " to complete 5 km");
    }
}
