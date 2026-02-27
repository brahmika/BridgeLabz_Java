package junittesting;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserValidator {
    private static final String regex = "^[A-Z][a-z]{2,}$";
    private static final Pattern pattern = Pattern.compile(regex);

    public static boolean isValidFirstName(String firstName){
        if(firstName == null){
            return false;
        }
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }
}
