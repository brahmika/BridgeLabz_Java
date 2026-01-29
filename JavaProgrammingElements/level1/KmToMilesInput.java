// Converts user-entered kilometers into miles.

import java.util.Scanner;//importing Scanner module
public class KmToMilesInput {
    public static void main(String[] args){
        double km;
        Scanner input = new Scanner(System.in);
        km = input.nextInt();
        double mile = 1.6 * km;//conversion of the measurement units.
        System.out.println(mile);
        input.close();
    }
    
}
