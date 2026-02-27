package junittesting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UserValidatorRule1Test {

    @Test
    void validPasswordRule1_ShouldReturnTrue() {
        assertTrue(UserValidatorRule1.isValidPasswordRule1("abcdefgh"));
        assertTrue(UserValidatorRule1.isValidPasswordRule1("password123"));
        assertTrue(UserValidatorRule1.isValidPasswordRule1("Abc@12345"));
    }

    @Test
    void invalidPasswordRule1_ShouldReturnFalse() {
        assertFalse(UserValidatorRule1.isValidPasswordRule1("abc"));      // less than 8
        assertFalse(UserValidatorRule1.isValidPasswordRule1("1234567"));  // 7 chars
        assertFalse(UserValidatorRule1.isValidPasswordRule1(null));
    }
}