package org.example.springbootapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.example.springbootapp.MovieGenre.DRAMA;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MovieRepoTest {

    @Autowired
    private MovieRepo repo;

    @Test
    public void testFindAll() {
        assertEquals(10, repo.findAll().size());
    }

    // TODO: write some more tests for the repo's methods

    @Test
    public void testFindByTitleAndReleaseYear() {
        Movie movie = repo.findByTitleAndReleaseYear("Selma", 2014);
        assertEquals(DRAMA, movie.getGenre());
    }

    @Test
    public void testFindByTitleLike() {
        Page<Movie> page = repo.findByTitleLike("%Lady%", PageRequest.of(0, 3));
        assertEquals(2, page.getTotalElements());
        assertFalse(page.hasNext());
    }

    // Fetching

    @Test
    public void testFindById() {
        Movie movie = repo.findById(1L).get();
        assertEquals(3, movie.getActors().size());
    }

    @Test
    public void testEagerFindById() {
        Movie movie = repo.eagerFindById(1L).get();
        assertEquals(3, movie.getActors().size());
    }
}
