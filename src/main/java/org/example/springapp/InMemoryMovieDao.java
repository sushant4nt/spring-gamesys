package org.example.springapp;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class InMemoryMovieDao implements MovieDao {

    private List<Movie> movies;

    public InMemoryMovieDao() {
        movies = new CopyOnWriteArrayList<>();
    }

    public long add(Movie newMovie) {
        movies.add(newMovie);
        return newMovie.getId();
    }

    public List<Movie> findByTitleLike(String partialTitle) {
        return movies
                .stream()
                .filter(m -> m.getTitle().toLowerCase().contains(partialTitle.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Movie> findByGenre(MovieGenre genre) {
        return movies.stream().filter(m -> m.getGenre() == genre).collect(Collectors.toList());
    }

    public List<Movie> findByReleaseYear(int releaseYear) {
        return movies.stream().filter(m -> m.getReleaseYear() == releaseYear).collect(Collectors.toList());
    }

    public Movie findById(long id) throws NoSuchMovieException {
        return movies.stream().filter(m -> m.getId() == id).findFirst().orElseThrow(NoSuchMovieException::new);
    }

    public void update(Movie updatedMovie) throws NoSuchMovieException {
        Movie movie = findById(updatedMovie.getId());
        movie.setTitle(updatedMovie.getTitle());
        movie.setGenre(updatedMovie.getGenre());
        movie.setReleaseYear(updatedMovie.getReleaseYear());
    }

    public void delete(Movie movieToDelete) throws NoSuchMovieException {
        Movie movie = findById(movieToDelete.getId());
        movies.remove(movie);
    }

    public int size() {
        return movies.size();
    }
}