package org.example.springbootapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(InvalidEntityException.class)
    private ResponseEntity<Void> handleInvalidEntities(InvalidEntityException e) {
        String errors = e.getErrors()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
        return ResponseEntity.badRequest().header("errors", errors).build();
    }

    @ExceptionHandler(NoSuchEntityException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleNoSuchEntity() {}
}
