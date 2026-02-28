/*
 * Task: Password Rule Validation
 * Rule 1: Minimum 8 Characters.
 * Rule 2: At least 1 Upper Case letter.
 * Rule 3: At least 1 Numeric number.
 * Rule 4: Has EXACTLY 1 Special Character.
 * Note: All rules must be passed (Logical AND).
 */
package lambdaexpressions;
import java.util.function.Predicate;
public class PasswordRule4 {
    public static void main(String[] args) {

        // Rule 1: Minimum 8 characters
        Predicate<String> minLength = p -> p != null && p.length() >= 8;

        // Rule 2: At least one Uppercase letter
        Predicate<String> hasUppercase = p -> p != null && p.matches(".*[A-Z].*");

        // Rule 3: At least one Numeric digit
        Predicate<String> hasNumeric = p -> p != null && p.matches(".*[0-9].*");

        // Rule 4: Exactly 1 Special Character
        // Regex Breakdown:
        // ^[^a-zA-Z0-9]* -> Start with any number of non-alphanumeric chars
        // [!@#$%^&*]       -> Exactly ONE special char
        // [a-zA-Z0-9]*$    -> Followed only by alphanumeric chars until the end
        // Alternative Logic: Check if the string without alphanumeric chars has length 1
        Predicate<String> hasExactlyOneSpecial = p -> p != null &&
                p.replaceAll("[a-zA-Z0-9]", "").length() == 1;

        // Combining all rules
        Predicate<String> isValidPassword = minLength
                .and(hasUppercase)
                .and(hasNumeric)
                .and(hasExactlyOneSpecial);

        // Test Cases
        System.out.println("Result for 'Password123': " + isValidPassword.test("Password123"));   // false (0 special)
        System.out.println("Result for 'Pass123!@': " + isValidPassword.test("Pass123!@"));      // false (2 special)
        System.out.println("Result for 'Password123!': " + isValidPassword.test("Password123!")); // true (Exactly 1)
    }
}
