package junittesting;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NumericValueValidator {

    private static final String REGEX = "^(?=.*[0-9]).+$";
    private static final Pattern pattern = Pattern.compile(REGEX);

    public static boolean validate(String password) {
        if (password == null) return false;
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}