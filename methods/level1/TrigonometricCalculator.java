// Calculates sine, cosine, and tangent for a given angle using Math class.

import java.util.Scanner;

public class TrigonometricCalculator {

    public static double calculateWindChill(double temperature, double windSpeed) {

        double windChill = 35.74 
                + (0.6215 * temperature)
                + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);

        return windChill;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit: ");
        double temperature = sc.nextDouble();

        System.out.print("Enter wind speed in mph: ");
        double windSpeed = sc.nextDouble();

        double result = calculateWindChill(temperature, windSpeed);

        System.out.println("The Wind Chill Temperature is: " + result);

        sc.close();
    }
}
