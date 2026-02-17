/*
 Password Rule 4
 Must contain exactly one special character.
*/
package regex;

import java.util.regex.Pattern;

public class PasswordRule4 {

    public static boolean validate(String password) {
        return Pattern.matches("^[a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*$", password);
    }

    public static void main(String[] args) {
        System.out.println(validate("Password1@"));
    }
}
