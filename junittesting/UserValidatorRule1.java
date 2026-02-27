package junittesting;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class UserValidatorRule1 {

    private static final String PASSWORD_RULE1_REGEX = "^.{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_RULE1_REGEX);

    public static boolean isValidPasswordRule1(String password) {
        if (password == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}