package org.example.springbootapp;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.example.springbootapp.models.Movie;
import org.example.springbootapp.repos.QuerydslMovieRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.example.springbootapp.models.MovieGenre.DRAMA;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class QuerydslMovieRepoTest {

    @Autowired
    private QuerydslMovieRepo repo;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFindByTitleAndReleaseYear() {
        assertEquals(DRAMA, repo.findByTitleAndReleaseYear("Selma", 2014).getGenre());
    }

    @Test
    public void testQuerydslDynamicQuery() {
        String key = "title";
        String value = "Argo";
        PathBuilder<Movie> movie = new PathBuilder<Movie>(Movie.class, "movie");
        Predicate predicate = movie.getString(key).eq(value);
        JPAQuery<Movie> query = new JPAQuery<>(entityManager);
        assertEquals(2012, query.from(movie).where(predicate).fetchOne().getReleaseYear());
    }
}
