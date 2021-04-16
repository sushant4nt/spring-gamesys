package org.example.springbootapp;

import org.springframework.validation.Errors;

public class InvalidSongException extends InvalidEntityException {

    public InvalidSongException(Errors errors) {
        super(errors);
    }
}
