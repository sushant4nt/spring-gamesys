package org.example.springbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongRepo repo;

    @ExceptionHandler(InvalidSongException.class)
    private ResponseEntity<Void> handleInvalidSongs(InvalidSongException e) {
        String errors = e.getErrors()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
        return ResponseEntity.badRequest().header("errors", errors).build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Song addNewSong(@RequestBody @Validated Song song, Errors errors) throws InvalidSongException {
        if (errors.hasErrors()) {
            throw new InvalidSongException(errors);
        }
        return repo.save(song);
    }

    @GetMapping
    public List<Song> getAllSongs() {
        return repo.findAll();
    }
}
