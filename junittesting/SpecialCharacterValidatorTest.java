package junittesting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SpecialCharacterValidatorTest {

    @Test
    void validPasswords() {
        assertTrue(SpecialCharacterValidator.validate("Pass@word"));
    }

    @Test
    void invalidPasswords() {
        assertFalse(SpecialCharacterValidator.validate("Pass@@word"));
        assertFalse(SpecialCharacterValidator.validate("Password"));
        assertFalse(SpecialCharacterValidator.validate(null));
    }
}