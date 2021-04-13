package org.example.springapp;

import java.util.List;

public interface MovieDao {

    long add(Movie movie);

    List<Movie> findByTitleLike(String partialTitle);

    List<Movie> findByGenre(MovieGenre genre);

    List<Movie> findByReleaseYear(int releaseYear);

    Movie findById(long id) throws NoSuchMovieException;

    void update(Movie movie) throws NoSuchMovieException;

    void delete(Movie movie) throws NoSuchMovieException;

    int size();
}