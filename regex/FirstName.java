/*
 First Name Validation
 First name must start with a capital letter
 and have minimum 3 characters.
*/
package regex;

import java.util.regex.Pattern;

public class FirstName {

    public static boolean validateFirstName(String firstName) {
        return Pattern.matches("^[A-Z][a-z]{2,}$", firstName);
    }

    public static void main(String[] args) {
        System.out.println(validateFirstName("John"));
    }
}
