package com.stackroute.handler;

import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MuzixExceptionHandler {

    @ExceptionHandler
    public String handleAlreadyExistsException(TrackAlreadyExistsException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler
    public String handleNotFoundException(TrackNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler
    public String handleException(Exception exception) {
        return exception.getMessage();
    }

}
