// Demonstrate StringIndexOutOfBoundsException using charAt() and handle it


import java.util.Scanner;

public class YoungestTallestFriend  {

    public static void generateException(String text) {
        System.out.println(text.charAt(text.length())); // Index out of bounds
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length())); // Index out of bounds
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        // Uncomment the line below to see the program crash
        // generateException(input);

        handleException(input);

        sc.close();
    }
}
