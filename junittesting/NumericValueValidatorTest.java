package junittesting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class NumericValueValidatorTest {

    @Test
    void validPasswords() {
        assertTrue(NumericValueValidator.validate("pass1word"));
    }

    @Test
    void invalidPasswords() {
        assertFalse(NumericValueValidator.validate("password"));
        assertFalse(NumericValueValidator.validate(null));
    }
}