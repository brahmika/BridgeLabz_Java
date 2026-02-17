/*
 Validate Multiple Email Samples
*/
package regex;

import java.util.regex.Pattern;

public class EmailSamples {

    public static boolean validateEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)?@[a-zA-Z0-9]+\\.[a-z]{2,}(\\.[a-z]{2,})?$", email);
    }

    public static void main(String[] args) {

        String[] emails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc@.com",
                "abc@abc@gmail.com"
        };

        for (String email : emails) {
            System.out.println(email + " -> " + validateEmail(email));
        }
    }
}
