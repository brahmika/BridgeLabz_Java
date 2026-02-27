package junittesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FullPasswordValidatorTest {

    @Test
    void validEmails_ShouldReturnTrue() {
        assertTrue(FullPasswordValidator.validate("abc@yahoo.com"));
        assertTrue(FullPasswordValidator.validate("abc-100@yahoo.com"));
        assertTrue(FullPasswordValidator.validate("abc.100@yahoo.com"));
        assertTrue(FullPasswordValidator.validate("abc111@abc.com"));
        assertTrue(FullPasswordValidator.validate("abc-100@abc.net"));
        assertTrue(FullPasswordValidator.validate("abc.100@abc.com.au"));
        assertTrue(FullPasswordValidator.validate("abc@1.com"));
        assertTrue(FullPasswordValidator.validate("abc@gmail.com.com"));
        assertTrue(FullPasswordValidator.validate("abc+100@gmail.com"));
    }

    @Test
    void invalidEmails_ShouldReturnFalse() {
        assertFalse(FullPasswordValidator.validate("abc"));
        assertFalse(FullPasswordValidator.validate("abc@.com"));
        assertFalse(FullPasswordValidator.validate("abc123@gmail.a"));
        assertFalse(FullPasswordValidator.validate("abc123@.com"));
        assertFalse(FullPasswordValidator.validate("abc123@.com.com"));
        assertFalse(FullPasswordValidator.validate(".abc@abc.com"));
        assertFalse(FullPasswordValidator.validate("abc()*@gmail.com"));
        assertFalse(FullPasswordValidator.validate("abc@%*.com"));
        assertFalse(FullPasswordValidator.validate("abc..2002@gmail.com"));
        assertFalse(FullPasswordValidator.validate(null));
    }
}