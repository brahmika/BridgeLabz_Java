package junittesting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PasswordValidatorTest {

    @Test
    void validPasswords() {
        assertTrue(PasswordValidator.validate("Password"));
    }

    @Test
    void invalidPasswords() {
        assertFalse(PasswordValidator.validate("password"));
        assertFalse(PasswordValidator.validate(null));
    }
}