/*
 Problem Statement 3: Throw and Throws
 Demonstrates custom checked exceptions for user registration.
*/
package exceptions;

import java.util.HashSet;
import java.util.Set;

class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class UserService {

    private Set<String> users = new HashSet<>();

    public void registerUser(String username) throws UserAlreadyExistsException {
        if (users.contains(username)) {
            throw new UserAlreadyExistsException("User already exists: " + username);
        }
        users.add(username);
        System.out.println("User registered: " + username);
    }

    public void checkUserExistence(String username) throws UserNotFoundException {
        if (!users.contains(username)) {
            throw new UserNotFoundException("User not found: " + username);
        }
        System.out.println("User exists: " + username);
    }
}
