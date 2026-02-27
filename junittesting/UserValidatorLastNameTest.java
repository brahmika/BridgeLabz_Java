package junittesting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class UserValidatorLastNameTest {

    @Test
    void validLastName(){
        assertTrue(UserValidator.isValidFirstName("Shree"));
        assertTrue(UserValidator.isValidFirstName("Roy"));
        assertTrue(UserValidator.isValidFirstName("Nair"));
    }

    @Test
    void invalidLastName(){
        assertFalse(UserValidator.isValidFirstName("shree"));
        assertFalse(UserValidator.isValidFirstName(null));
        assertFalse(UserValidator.isValidFirstName("SHREE"));
        assertFalse(UserValidator.isValidFirstName("sh"));
        assertFalse(UserValidator.isValidFirstName("Sh"));
        assertFalse(UserValidator.isValidFirstName("shree1"));
        assertFalse(UserValidator.isValidFirstName("s5ree"));

    }
}
