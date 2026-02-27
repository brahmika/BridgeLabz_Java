package junittesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorEmailTest {

    @Test
    void validEmails_ShouldReturnTrue() {
        assertTrue(UserValidatorEmail.isValidEmail("abc@xyz.pqr"));
        assertTrue(UserValidatorEmail.isValidEmail("abc.xyz@def.ghi"));
        assertTrue(UserValidatorEmail.isValidEmail("abc@def.ghi.in"));
        assertTrue(UserValidatorEmail.isValidEmail("abc.xyz@def.ghi.in"));
    }

    @Test
    void invalidEmails_ShouldReturnFalse() {
        assertFalse(UserValidatorEmail.isValidEmail("abc@xy.pqr"));      // domain < 3 letters
        assertFalse(UserValidatorEmail.isValidEmail("abc@xyz.pq"));      // extension < 3
        assertFalse(UserValidatorEmail.isValidEmail("abc@xyz.pqr.ind")); // country > 2
        assertFalse(UserValidatorEmail.isValidEmail("abc@xyzpqr"));      // no dot
        assertFalse(UserValidatorEmail.isValidEmail("abc@xyz..pqr"));    // double dot
        assertFalse(UserValidatorEmail.isValidEmail(null));
    }
}