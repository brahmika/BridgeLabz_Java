import java.util.Scanner;
public class L108 {
    public static void main(String[] args){
        double km;
        Scanner input = new Scanner(System.in);
        km = input.nextInt();
        double mile = 1.6 * km;
        System.out.println(mile);
        input.close();
    }
    
}
