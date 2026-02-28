/*
 * Task: Password Rule Validation
 * Rule 1: Minimum 8 Characters.
 * Implementation: Functional Interface (Predicate) using Lambda Expressions.
 * Note: This rule must be passed along with any subsequent rules.
 */
package lambdaexpressions;
import java.util.function.Predicate;
public class PasswordRule1 {
    public static void main(String[] args){

    // Rule 1: Minimum 8 characters
    // We check if the string is not null and length >= 8
    Predicate<String> hasMinLength = password ->
            password != null && password.length() >= 8;

    // Testing the logic
            System.out.println("Result for '12345': " + hasMinLength.test("12345"));       // false
            System.out.println("Result for 'password': " + hasMinLength.test("password")); // true
            System.out.println("Result for 'Admin123': " + hasMinLength.test("Admin123")); // true
}
}
