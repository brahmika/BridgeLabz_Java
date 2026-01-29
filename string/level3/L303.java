import java.util.Scanner;

class L303 {

    static char firstNonRepeatingChar(String text) {
        int[] freq = new int[256]; // ASCII character frequencies

        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (RuntimeException e) {
        }

        // Count frequency
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Find first non-repeating character
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // Return null char if no non-repeating character
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        char result = firstNonRepeatingChar(input);
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found");
        }

        sc.close();
    }
}
