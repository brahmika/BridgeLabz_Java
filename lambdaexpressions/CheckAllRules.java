/*
 * Task: Email Validation for Specific Samples
 * Samples to Clear:
 * 1. abc.xyz@bl.co.in (All parts present)
 * 2. abc@bl.co (Mandatory parts only)
 * * Rules:
 * - Mandatory: recipient (abc), domain (bl), TLD (co)
 * - Optional: sub-recipient (.xyz), country code (.in)
 */
package lambdaexpressions;
import java.util.function.Predicate;
import java.util.regex.Pattern;
public class CheckAllRules {
    public static void main(String[] args) {

        // Regex Breakdown:
        // ^[a-z0-9]+          -> Mandatory 'abc'
        // (\\.[a-z0-9]+)?     -> Optional '.xyz'
        // @                   -> Mandatory '@'
        // [a-z0-9]+           -> Mandatory 'bl'
        // \\.[a-z]{2,}        -> Mandatory '.co' (min 2 chars)
        // (\\.[a-z]{2,})?$    -> Optional '.in'

        String emailRegex = "^[a-z0-9]+(\\.[a-z0-9]+)?@[a-z0-9]+\\.[a-z]{2,}(\\.[a-z]{2,})?$";

        // Lambda Expression
        Predicate<String> isValidEmail = email ->
                email != null && email.matches(emailRegex);

        // Validating Samples
        System.out.println("Testing abc.xyz@bl.co.in: " + isValidEmail.test("abc.xyz@bl.co.in")); // true
        System.out.println("Testing abc@bl.co: " + isValidEmail.test("abc@bl.co"));           // true

        // Testing Invalid Samples
        System.out.println("Testing abc@bl: " + isValidEmail.test("abc@bl"));                 // false (missing TLD)
        System.out.println("Testing .abc@bl.co: " + isValidEmail.test(".abc@bl.co"));         // false (cannot start with dot)
    }
}
