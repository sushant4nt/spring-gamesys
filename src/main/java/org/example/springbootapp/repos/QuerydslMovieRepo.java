package org.example.springbootapp.repos;

import com.querydsl.jpa.impl.JPAQuery;
import org.example.springbootapp.models.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.example.springbootapp.models.QMovie.movie;

@Repository
public class QuerydslMovieRepo {

    // This is like @Autowired but the EntityManager is created from the factory and bound to the thread
    @PersistenceContext
    private EntityManager entityManager;

    public List<Movie> findAll() {
        return entityManager.createQuery("from Movie").getResultList();
    }

    public Movie findById(long id) {
        return entityManager.find(Movie.class, id);
    }

    public Movie findByTitleAndReleaseYear(String title, int releaseYear) {

//        TypedQuery<Movie> query = entityManager
//                .createQuery("from Movie m where m.title = ?1 and m.releaseYear = ?2", Movie.class);
//        query.setParameter(1, title);
//        query.setParameter(2, releaseYear);
//        return query.getSingleResult();

        JPAQuery<Movie> query = new JPAQuery<>(entityManager);
        return query.from(movie).where(movie.title.eq(title).and(movie.releaseYear.eq(releaseYear))).fetchOne();
    }

    public Movie findByTitleIgnoreCase(String title) {
        return null;
    }

    public Movie save(Movie movie) {
        return null;
    }

    public void deleteById(long id) {
    }
}
