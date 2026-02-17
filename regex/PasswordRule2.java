/*
 Password Rule 2
 Must contain at least one uppercase letter.
*/
package regex;

import java.util.regex.Pattern;

public class PasswordRule2 {

    public static boolean validate(String password) {
        return Pattern.matches(".*[A-Z].*", password);
    }

    public static void main(String[] args) {
        System.out.println(validate("Password1@"));
    }
}
