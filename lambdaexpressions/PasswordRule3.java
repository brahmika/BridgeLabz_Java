/*
 * Task: Password Rule Validation
 * Rule 1: Minimum 8 Characters.
 * Rule 2: At least 1 Upper Case letter.
 * Rule 3: At least 1 Numeric number.
 * Note: All rules must be passed (Logical AND).
 */
package lambdaexpressions;
import java.util.function.Predicate;
public class PasswordRule3 {
    public static void main(String[] args) {

        // Rule 1: Minimum 8 characters
        Predicate<String> minLength = p -> p != null && p.length() >= 8;

        // Rule 2: At least one Uppercase letter
        // Regex: .* matches any character, [A-Z] matches an uppercase letter
        Predicate<String> hasUppercase = p -> p != null && p.matches(".*[A-Z].*");

        // Rule 3: At least one Numeric digit
        // Regex: .* matches any character, [0-9] or \\d matches a digit
        Predicate<String> hasNumeric = p -> p != null && p.matches(".*[0-9].*");

        // Combining all rules (The "All rules must be passed" requirement)
        Predicate<String> isValidPassword = minLength
                .and(hasUppercase)
                .and(hasNumeric);

        // Test Cases
        System.out.println("Result for 'Pass123': " + isValidPassword.test("Pass123"));   // false (too short)
        System.out.println("Result for 'password123': " + isValidPassword.test("password123")); // false (no Uppercase)
        System.out.println("Result for 'Password': " + isValidPassword.test("Password"));       // false (no Number)
        System.out.println("Result for 'Password123': " + isValidPassword.test("Password123")); // true (All pass)
    }
}
