package org.example.springbootapp;

import org.springframework.validation.Errors;

public class InvalidEntityException extends Exception {

    private Errors errors;

    public InvalidEntityException(Errors errors) {
        this.errors = errors;
    }

    public InvalidEntityException() {
    }

    public Errors getErrors() {
        return errors;
    }
}
