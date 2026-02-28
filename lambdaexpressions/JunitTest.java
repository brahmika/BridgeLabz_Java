package lambdaexpressions;
import java.util.function.Predicate;
public class JunitTest {
        public static Predicate<String> isFirstNameValid = n -> n != null && n.matches("^[A-Z][a-zA-Z]{2,}$");
        public static Predicate<String> isLastNameValid = n -> n != null && n.matches("^[A-Z][a-zA-Z]{2,}$");
        public static Predicate<String> isEmailValid = e -> e != null && e.matches("^[a-z0-9]+(\\.[a-z0-9]+)?@[a-z0-9]+\\.[a-z]{2,}(\\.[a-z]{2,})?$");
        public static Predicate<String> isMobileValid = m -> m != null && m.matches("^[0-9]{1,3}\\s[0-9]{10}$");
        public static Predicate<String> isPasswordValid = p -> p != null &&
                p.length() >= 8 &&
                p.matches(".*[A-Z].*") &&
                p.matches(".*[0-9].*") &&
                p.replaceAll("[a-zA-Z0-9]", "").length() == 1;
}
