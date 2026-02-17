/*
 Password Rule 1
 Must have minimum 8 characters.
*/
package regex;

public class PasswordRule1 {

    public static boolean validate(String password) {
        return password.length() >= 8;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password1@"));
    }
}
