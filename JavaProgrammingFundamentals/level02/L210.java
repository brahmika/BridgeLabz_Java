import java.util.Scanner;

public class L210 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input for total chocolates and number of children
        System.out.print("Enter the total number of chocolates: ");
        int numberOfChocolates = sc.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = sc.nextInt();

        // Calculate chocolates per child and remaining chocolates
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        System.out.println("The number of chocolates each child gets is " 
                           + chocolatesPerChild + 
                           " and the number of remaining chocolates are " 
                           + remainingChocolates);
    }
}
