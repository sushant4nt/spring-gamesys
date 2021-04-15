package org.example.springbootapp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie, Long> {

    Movie findByTitleAndReleaseYear(String title, int releaseYear);

    Page<Movie> findByTitleLike(String partialTitle, Pageable pageable);

    // This is JPQL, not SQL.
    // JPQL enables us to write platform agnostic queries that are assoc. with the class, not the table
    @Query("from Movie m left join fetch m.actors where m.id = ?1")
    Optional<Movie> eagerFindById(long id);
}
