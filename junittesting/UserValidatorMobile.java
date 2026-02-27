package junittesting;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserValidatorMobile {

    private static final String MOBILE_REGEX =
            "^[0-9]{2} [0-9]{10}$";

    private static final Pattern pattern = Pattern.compile(MOBILE_REGEX);

    public static boolean isValidMobile(String mobile) {
        if (mobile == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }
}