package org.example.bootopenapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "/songs",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SongController {

    @Autowired
    private SongRepo repo;

    @ExceptionHandler(NoSuchSongException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleNoSuchSong() {}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Song> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Song getById(@PathVariable long id) throws NoSuchSongException {
        return repo.findById(id).orElseThrow(NoSuchSongException::new);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Song add(@RequestBody Song song) {
        return repo.save(song);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @RequestBody Song song) throws NoSuchSongException {
        repo.findById(id).orElseThrow(NoSuchSongException::new);
        song.setId(id);
        repo.save(song);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) throws NoSuchSongException {
        repo.findById(id).orElseThrow(NoSuchSongException::new);
        repo.deleteById(id);
    }
}
