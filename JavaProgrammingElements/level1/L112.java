import java.util.Scanner;

public class L112 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base in inches: ");
        double base = sc.nextDouble();

        System.out.print("Enter height in inches: ");
        double height = sc.nextDouble();

        double areaInSqInches = 0.5 * base * height;

        // 1 square inch = 6.4516 square cm
        double areaInSqCm = areaInSqInches * 6.4516;

        System.out.println("The area of triangle with base " + base +
                " inches and height " + height +
                " inches is " + areaInSqInches +
                " square inches and " + areaInSqCm +
                " square centimeters.");
    }
}
