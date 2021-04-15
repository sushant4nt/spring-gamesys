package org.example.springbootapp;

import org.springframework.validation.Errors;

public class InvalidSongException extends Exception {

    private Errors errors;
    public InvalidSongException(Errors errors) {
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
