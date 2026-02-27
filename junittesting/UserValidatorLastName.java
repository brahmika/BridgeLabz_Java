package junittesting;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserValidatorLastName {
    private static final String regex = "^[A-Z][a-z]{2,}$";
    private static final Pattern pattern = Pattern.compile(regex);

    public static boolean isValidLastName(String lastName){
        if (lastName == null){
            return false;
        }
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }
}
