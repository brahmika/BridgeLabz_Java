// Objects L108
class PalindromeChecker {

    String text;
    boolean isPalindrome;

    PalindromeChecker(String text) {
        this.text = text;
    }


    void checkPalindrome() {
        int start = 0;
        int end = text.length() - 1;
        isPalindrome = true;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
    }


    void displayResult() {
        if (isPalindrome) {
            System.out.println(text + " is a Palindrome");
        } else {
            System.out.println(text + " is not a Palindrome");
        }
    }

    public static void main(String[] args) {

        PalindromeChecker checker =
                new PalindromeChecker("madam");

        checker.checkPalindrome();
        checker.displayResult();
    }
}
