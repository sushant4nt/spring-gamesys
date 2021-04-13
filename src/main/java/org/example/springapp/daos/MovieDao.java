package org.example.springapp.daos;

import org.example.springapp.models.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> findAll();

    Movie findById(long id);

    Movie findByTitleAndReleaseYear(String title, int releaseYear);

    long add(Movie movie);

    void update(Movie movie);

    void delete(long id);
}
