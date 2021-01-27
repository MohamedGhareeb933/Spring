package com.mohamedghareeb.springboot.cruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionMessage> EmployeNotFoundExcpeion(EmployeeExceptionThrower exc) {
        EmployeeExceptionMessage message = new EmployeeExceptionMessage(
                exc.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                System.currentTimeMillis());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionMessage> EmployeeBadRequestException(Exception exc) {
        EmployeeExceptionMessage message = new EmployeeExceptionMessage(
                exc.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                System.currentTimeMillis());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
