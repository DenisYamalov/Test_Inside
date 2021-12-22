package ru.inside.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.inside.Exceptions.MyException;

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    private String maxPressureHandler(MyException myException) {

        return myException.getMessage();
    }

}
