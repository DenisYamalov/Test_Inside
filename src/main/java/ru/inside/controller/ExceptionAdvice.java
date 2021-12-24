package ru.inside.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.inside.Exceptions.SecurityException;

/**
 * Advisor to handle custom exceptions
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(SecurityException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    private String wrongPasswordOrNoSuchUserHandler(SecurityException securityException) {

        return securityException.getMessage();
    }

}
