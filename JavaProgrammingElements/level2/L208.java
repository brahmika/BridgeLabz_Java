import java.util.Scanner;

public class L208 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User inputs for names and cities
        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter starting city (fromCity): ");
        String fromCity = sc.nextLine();

        System.out.print("Enter via city (viaCity): ");
        String viaCity = sc.nextLine();

        System.out.print("Enter destination city (toCity): ");
        String toCity = sc.nextLine();

        // User inputs for distances in miles
        System.out.print("Enter distance from starting city to viaCity (in miles): ");
        double fromToVia = sc.nextDouble();

        System.out.print("Enter distance from viaCity to final destination (in miles): ");
        double viaToFinalCity = sc.nextDouble();

        // User input for time taken in hours
        System.out.print("Enter total time taken (in hours): ");
        double timeTaken = sc.nextDouble();

        // Sample integer operations using distances and time to illustrate precedence
        double operation1 = fromToVia + viaToFinalCity * timeTaken;
        double operation2 = fromToVia * viaToFinalCity + timeTaken;
        double operation3 = timeTaken + fromToVia / viaToFinalCity;

        System.out.println("\nPassenger: " + name);
        System.out.println("Route: " + fromCity + " -> " + viaCity + " -> " + toCity);
        System.out.println("Distances: " + fromToVia + " miles and " + viaToFinalCity + " miles");
        System.out.println("Time taken: " + timeTaken + " hours");

        System.out.println("\nThe results of Int Operations are "
                + operation1 + ", " + operation2 + ", and " + operation3);
    }
}
