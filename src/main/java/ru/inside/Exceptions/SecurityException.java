package ru.inside.Exceptions;

/**
 * Custom exception to throw if user doesn't exist yet or if the password is wrong
 */
public class SecurityException extends Exception {
    public SecurityException(String message) {

        super(message);
    }
}
