package junittesting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    @Test
    void validFirstName(){
        assertTrue(UserValidator.isValidFirstName("Brahmika"));
        assertTrue(UserValidator.isValidFirstName("Bob"));
        assertTrue(UserValidator.isValidFirstName("Alice"));
    }

    @Test
    void invalidFirstName(){
        assertFalse(UserValidator.isValidFirstName("brahmika"));
        assertFalse(UserValidator.isValidFirstName("br"));
        assertFalse(UserValidator.isValidFirstName("BRAHMIKA"));
        assertFalse(UserValidator.isValidFirstName("brahm1ka"));
        assertFalse(UserValidator.isValidFirstName("1brahmika"));
        assertFalse(UserValidator.isValidFirstName("B"));
        assertFalse(UserValidator.isValidFirstName(null));
    }
}
