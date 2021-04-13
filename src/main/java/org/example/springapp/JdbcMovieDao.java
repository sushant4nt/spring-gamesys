package org.example.springapp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("jdbc")
@Component
public class JdbcMovieDao implements MovieDao {

    @Override
    public long add(Movie movie) {
        return 0;
    }

    @Override
    public List<Movie> findByTitleLike(String partialTitle) {
        return null;
    }

    @Override
    public List<Movie> findByGenre(MovieGenre genre) {
        return null;
    }

    @Override
    public List<Movie> findByReleaseYear(int releaseYear) {
        return null;
    }

    @Override
    public Movie findById(long id) throws NoSuchMovieException {
        return null;
    }

    @Override
    public void update(Movie movie) throws NoSuchMovieException {

    }

    @Override
    public void delete(Movie movie) throws NoSuchMovieException {

    }

    @Override
    public int size() {
        return 0;
    }
}
