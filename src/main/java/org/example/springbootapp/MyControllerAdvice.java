package org.example.springbootapp;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(InvalidSongException.class)
    private ResponseEntity<Void> handleInvalidSongs(InvalidSongException e) {
        String errors = e.getErrors()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
        return ResponseEntity.badRequest().header("errors", errors).build();
    }
}
