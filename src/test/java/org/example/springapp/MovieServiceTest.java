package org.example.springapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.example.springapp.MovieGenre.COMEDY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieServiceTest {

    private ApplicationContext context;
    private MovieService service;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(AppContextConfig.class);
        service = context.getBean(MovieService.class);
    }

    @Test
    public void testAdd() throws NoSuchMovieException {
        long id = service.add(new Movie("Wayne's World", COMEDY, 1992));
        assertEquals("Wayne's World", service.findByTitleLike("Wayne").get(0).getTitle());
    }

    // TODO: write more tests
}
