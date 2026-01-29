import java.util.Scanner;

public class L102 {

    public static String createSubstringCharAt(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result = result + str.charAt(i);
        }
        return result;
    }

    public static boolean compareStringsCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        String subCharAt = createSubstringCharAt(text, start, end);
        String subBuiltIn = text.substring(start, end);

        boolean result = compareStringsCharAt(subCharAt, subBuiltIn);

        System.out.println(subCharAt);
        System.out.println(subBuiltIn);

        if (result) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        sc.close();
    }
}
