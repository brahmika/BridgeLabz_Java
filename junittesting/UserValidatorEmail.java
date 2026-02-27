package junittesting;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserValidatorEmail {

    private static final String EMAIL_REGEX =
            "^[a-z]+(\\.[a-z]+)?@[a-z]{3}\\.[a-z]{3}(\\.[a-z]{2})?$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}