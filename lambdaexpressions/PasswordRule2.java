/*
 * Rule 2: Uppercase Requirement
 * Constraints:
 * 1. The input string must contain at least one Uppercase letter (A-Z).
 * 2. This is part of a multi-rule validation system.
 * 3. All previous rules (minimum length, etc.) must also be satisfied.
 */
package lambdaexpressions;
import java.util.function.Predicate;
public class PasswordRule2 {
    public static void main(String[] args) {

        // Rule 1: Minimum 8 characters (as a baseline example)
        Predicate<String> minLength = s -> s != null && s.length() >= 8;

        // Rule 2: At least one Uppercase letter
        // Regex Breakdown:
        // .* -> Any character (zero or more times)
        // [A-Z]    -> At least one uppercase letter
        // .* -> Followed by anything else
        Predicate<String> hasUppercase = s -> s != null && s.matches(".*[A-Z].*");

        // Combining Rules (All rules must be passed)
        Predicate<String> fullValidator = minLength.and(hasUppercase);

        // Test Cases
        System.out.println("Result for 'password': " + fullValidator.test("password")); // false (no Uppercase)
        System.out.println("Result for 'Password': " + fullValidator.test("Password")); // true (Length + Uppercase)
        System.out.println("Result for 'ABC': " + fullValidator.test("ABC"));           // false (too short)
    }
}
