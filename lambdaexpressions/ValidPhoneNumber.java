/*
 * Task: Mobile Number Validation
 * Constraints:
 * 1. Must follow a pre-defined format: Country Code + Space + 10-digit number.
 * 2. Example: "91 9919819801"
 * 3. Country code can vary in length (e.g., 91 or 1), but must be followed by
 * exactly one space and then exactly 10 digits.
 */
package lambdaexpressions;
import java.util.function.Predicate;
import java.util.regex.Pattern;
public class ValidPhoneNumber {
    public static void main(String[] args) {

        // Regex Breakdown:
        // ^[0-9]{1,3} -> Matches 1 to 3 digits for the Country Code
        // \s          -> Matches exactly one space
        // [0-9]{10}   -> Matches exactly 10 digits for the mobile number
        // $           -> End of string
        String mobileRegex = "^[0-9]{1,3}\\s[0-9]{10}$";

        // Pre-compiling the pattern for efficiency
        Pattern pattern = Pattern.compile(mobileRegex);

        // Lambda Expression
        Predicate<String> isValidMobile = phone ->
                phone != null && pattern.matcher(phone).matches();

        // Testing the logic
        System.out.println("Valid (91 9919819801): " + isValidMobile.test("91 9919819801"));
        System.out.println("No Space (919919819801): " + isValidMobile.test("919919819801"));
        System.out.println("Too Short (91 9819801): " + isValidMobile.test("91 9819801"));
        System.out.println("US Format (1 5550123456): " + isValidMobile.test("1 5550123456"));
    }
}
