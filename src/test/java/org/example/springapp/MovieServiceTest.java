package org.example.springapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.springapp.MovieGenre.COMEDY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieServiceTest {

    private MovieService service;

    @BeforeEach
    public void setUp() {
        service = new MovieService(new MovieDao());
    }

    @Test
    public void testAdd() throws NoSuchMovieException {
        long id = service.add(new Movie("Wayne's World", COMEDY, 1992));
        assertEquals("Wayne's World", service.findByTitleLike("Wayne").get(0).getTitle());
    }

    // TODO: write more tests
}
