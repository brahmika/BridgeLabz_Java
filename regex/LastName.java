/*
 Last Name Validation
 Last name must start with a capital letter
 and have minimum 3 characters.
*/
package regex;

import java.util.regex.Pattern;

public class LastName {

    public static boolean validateLastName(String lastName) {
        return Pattern.matches("^[A-Z][a-z]{2,}$", lastName);
    }

    public static void main(String[] args) {
        System.out.println(validateLastName("Doe"));
    }
}
