/*Implementation using the specific Regex pattern for a capitalized name with a minimum of 3 characters.*/
package lambdaexpressions;
import java.util.function.Predicate;
public class FirstNameVaid {
    public static void main(String[] args){

        String regex = "^[A-Z][a-zA-Z]{2,}$";
        Predicate<String> isValidName = name -> name != null && name.matches(regex);

        System.out.println(isValidName.test("jo"));
        System.out.println(isValidName.test("Bob"));
        System.out.println(isValidName.test("Brahmika"));
    }
}
