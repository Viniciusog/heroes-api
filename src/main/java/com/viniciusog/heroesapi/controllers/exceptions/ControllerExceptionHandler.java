package com.viniciusog.heroesapi.controllers.exceptions;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.viniciusog.heroesapi.services.exceptions.DatabaseException;
import com.viniciusog.heroesapi.services.exceptions.ResourceNotFoundException;
import org.hibernate.ResourceClosedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

//Intercepta as exceções faz um tratamento para elas
@ControllerAdvice
public class ControllerExceptionHandler {

    //Trata exceção do tipo ResourceNotFound
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found.";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(),
                error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }


    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String error =  "Database error.";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(),
                error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }
}
