package junittesting;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class FullPasswordValidator {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@" +
                    "[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean validate(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}