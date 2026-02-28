/*
 * Refactored User Validation using Lambda Functions.
 * This approach uses Lambdas to define the rules for:
 * First Name, Last Name, Email, Mobile, and Password.
 */

package lambdaexpressions;

import java.util.function.Predicate;

public class LambdaFunction {

    // Lambda Expressions for each validation rule
    public static final Predicate<String> FIRST_NAME_LAMBDA = name ->
            name != null && name.matches("^[A-Z][a-zA-Z]{2,}$");

    public static final Predicate<String> LAST_NAME_LAMBDA = name ->
            name != null && name.matches("^[A-Z][a-zA-Z]{2,}$");

    public static final Predicate<String> EMAIL_LAMBDA = email ->
            email != null && email.matches("^[a-z0-9]+(\\.[a-z0-9]+)?@[a-z0-9]+\\.[a-z]{2,}(\\.[a-z]{2,})?$");

    public static final Predicate<String> MOBILE_LAMBDA = mobile ->
            mobile != null && mobile.matches("^[0-9]{1,3}\\s[0-9]{10}$");

    public static final Predicate<String> PASSWORD_LAMBDA = pwd ->
            pwd != null && pwd.length() >= 8 &&
                    pwd.matches(".*[A-Z].*") &&
                    pwd.matches(".*[0-9].*") &&
                    pwd.replaceAll("[a-zA-Z0-9]", "").length() == 1;

    // Refactored method using the Lambda functions to throw Exceptions.