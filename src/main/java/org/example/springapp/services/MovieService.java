package org.example.springapp.services;

import org.example.springapp.daos.MovieDao;
import org.example.springapp.exceptions.DuplicateMovieException;
import org.example.springapp.exceptions.NonExistentMovieException;
import org.example.springapp.models.Movie;

import java.util.List;

public class MovieService {

    private MovieDao movieDao;

    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    public Movie findById(long id) throws NonExistentMovieException {
        return movieDao.findById(id);
    }

    public long add(Movie movie) throws DuplicateMovieException {
        // TODO: check for duplicate Movie
        return movieDao.add(movie);
    }

    // TODO: add the remaining methods
}
