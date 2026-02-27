package junittesting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorMobileTest {
    @Test
    void validMobile_ShouldReturnTrue() {
        assertTrue(UserValidatorMobile.isValidMobile("91 9919819801"));
        assertTrue(UserValidatorMobile.isValidMobile("44 1234567890"));
    }

    @Test
    void invalidMobile_ShouldReturnFalse() {
        assertFalse(UserValidatorMobile.isValidMobile("919919819801"));   // no space
        assertFalse(UserValidatorMobile.isValidMobile("91 991981980"));   // less than 10 digits
        assertFalse(UserValidatorMobile.isValidMobile("9 9919819801"));   // 1 digit country code
        assertFalse(UserValidatorMobile.isValidMobile("911 9919819801")); // 3 digit country code
        assertFalse(UserValidatorMobile.isValidMobile("91 99198A9801"));  // contains letter
        assertFalse(UserValidatorMobile.isValidMobile("91  9919819801")); // double space
        assertFalse(UserValidatorMobile.isValidMobile(null));
    }
}