package org.example.springapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.springapp.MovieGenre.COMEDY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryMovieDaoTest {

    private InMemoryMovieDao dao;

    @BeforeEach
    public void setUp() {
        dao = new InMemoryMovieDao();
    }

    @Test
    public void testAdd() throws NoSuchMovieException {
        long id = dao.add(new Movie("Wayne's World", COMEDY, 1992));
        assertEquals(1, dao.size());
        assertEquals("Wayne's World", dao.findById(id).getTitle());
    }

    // TODO: write more tests
}
