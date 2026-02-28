/*
 * Task: JUnit Parameterized Test for Email Validation
 * Requirement: Validate multiple successful and failing email entries.
 * Rules: 3 mandatory parts (abc, bl, co) and 2 optional (xyz, in).
 * Implementation: JUnit 5 @ParameterizedTest with @ValueSource.
 */
package lambdaexpressions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class ParameterisedTest {
    private final String emailRegex = "^[a-z0-9]+(\\.[a-z0-9]+)?@[a-z0-9]+\\.[a-z]{2,}(\\.[a-z]{2,})?$";

    @ParameterizedTest
    @ValueSource(strings = {
            "abc@bl.co",               // Mandatory parts only
            "abc.xyz@bl.co.in",        // All parts present
            "abc.123@bl.com.au",       // Numbers in recipient
            "user.name@domain.co.uk"   // Standard international format
    })
    void testEmailHappyCases(String email) {
        assertTrue(email.matches(emailRegex),
                "Expected email to be valid: " + email);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc@bl",                  // Missing TLD (.co)
            ".abc@bl.co",              // Starts with a dot
            "abc.xyz@bl..co",          // Double dots
            "abc@bl.c",                // TLD too short
            "abc.xyz@bl.co.in.au"      // Too many segments (exceeds optional rules)
    })
    void testEmailSadCases(String email) {
        assertFalse(email.matches(emailRegex),
                "Expected email to be invalid: " + email);
    }
}
