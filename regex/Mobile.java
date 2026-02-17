/*
 Mobile Number Validation
 Format: 91 9919819801
 Country code followed by space and 10 digit number.
*/
package regex;

import java.util.regex.Pattern;

public class Mobile {

    public static boolean validateMobile(String mobile) {
        return Pattern.matches("^[0-9]{2} [0-9]{10}$", mobile);
    }

    public static void main(String[] args) {
        System.out.println(validateMobile("91 9919819801"));
    }
}
