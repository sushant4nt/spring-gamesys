package org.example.springapp;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieService {

//    @Autowired
    private InMemoryMovieDao dao;

    public MovieService(InMemoryMovieDao dao) {
        this.dao = dao;
    }

    public long add(Movie newMovie) {
        // TODO: check newMovie is not a duplicate
        // TODO: validate newMovie
        return dao.add(newMovie);
    }

    public List<Movie> findByTitleLike(String partialTitle) {
        return dao.findByTitleLike(partialTitle);
    }

    public List<Movie> findByGenre(MovieGenre genre) {
        return dao.findByGenre(genre);
    }

    public List<Movie> findByReleaseYear(int releaseYear) {
        return dao.findByReleaseYear(releaseYear);
    }

    public void update(Movie updatedMovie) throws NoSuchMovieException {
        // TODO: validate updatedMovie
        dao.update(updatedMovie);
    }

    public void delete(Movie movieToDelete) throws NoSuchMovieException {
        dao.delete(movieToDelete);
    }
}
