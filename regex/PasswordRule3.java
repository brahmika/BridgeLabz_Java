/*
 Password Rule 3
 Must contain at least one numeric digit.
*/
package regex;

import java.util.regex.Pattern;

public class PasswordRule3 {

    public static boolean validate(String password) {
        return Pattern.matches(".*[0-9].*", password);
    }

    public static void main(String[] args) {
        System.out.println(validate("Password1@"));
    }
}
