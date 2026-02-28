/*
 * Task: Email Validation
 * Constraints:
 * 1. Mandatory parts: abc (recipient), bl (domain), and co (top-level domain).
 * 2. Optional parts: .xyz (sub-recipient/extension) and .in (country code).
 * 3. Specific positions for '@' and '.' separators.
 * Example Valid: abc.xyz@bl.co.in, abc@bl.co
 * Example Invalid: abc@bl, .abc@bl.co
 */
package lambdaexpressions;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ValidEmail {
    public static void main(String[] args) {
        String emailRegex = "^[a-z0-9]+(\\\\.[a-z0-9]+)?@[a-z0-9]+\\\\.[a-z]{2,}(\\\\.[a-z]{2,})?$";

        // Lambda Expression
        Predicate<String> isValidEmail = email ->
                email != null && Pattern.compile(emailRegex).matcher(email).matches();

        // Testing the logic
        System.out.println("Full match (abc.xyz@bl.co.in): " + isValidEmail.test("abc.xyz@bl.co.in"));
        System.out.println("Mandatory only (abc@bl.co): " + isValidEmail.test("abc@bl.co"));
        System.out.println("Invalid (abc@bl): " + isValidEmail.test("abc@bl"));

    }

}
