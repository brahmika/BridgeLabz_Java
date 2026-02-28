/*
 * Task: JUnit Validation for User Entry
 * Includes: Happy Test Cases (Success) and Sad Test Cases (Failure)
 * Fields: First Name, Last Name, Email, Mobile, Password
 */
package lambdaexpressions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import lambdaexpressions.JunitTest;
public class JunitTestTest {
    @Test
    @DisplayName("Happy Case: Valid First Name")
    void testFirstNameSuccess() {
        assertTrue(JunitTest.isFirstNameValid.test("Alice"));
    }

    @Test
    @DisplayName("Sad Case: Invalid First Name")
    void testFirstNameFailure() {
        assertFalse(JunitTest.isFirstNameValid.test("al")); // Lowercase and too short
    }

    // --- EMAIL TESTS ---
    @Test
    @DisplayName("Happy Case: Complex Email Valid")
    void testEmailSuccess() {
        assertTrue(JunitTest.isEmailValid.test("abc.xyz@bl.co.in"));
    }

    @Test
    @DisplayName("Sad Case: Email Missing TLD")
    void testEmailFailure() {
        assertFalse(JunitTest.isEmailValid.test("abc@bl"));
    }

    // --- MOBILE TESTS ---
    @Test
    @DisplayName("Happy Case: Mobile with Space")
    void testMobileSuccess() {
        assertTrue(JunitTest.isMobileValid.test("91 9919819801"));
    }

    @Test
    @DisplayName("Sad Case: Mobile without Space")
    void testMobileFailure() {
        assertFalse(JunitTest.isMobileValid.test("919919819801"));
    }

    // --- PASSWORD TESTS ---
    @Test
    @DisplayName("Happy Case: Password with 1 Special Char")
    void testPasswordSuccess() {
        assertTrue(JunitTest.isPasswordValid.test("Pass1234!"));
    }

    @Test
    @DisplayName("Sad Case: Password with 2 Special Chars")
    void testPasswordFailure() {
        assertFalse(JunitTest.isPasswordValid.test("Pass1234!!")); // Rule: Exactly 1 special
    }
}

