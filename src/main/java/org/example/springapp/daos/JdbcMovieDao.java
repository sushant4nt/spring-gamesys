package org.example.springapp.daos;

import org.example.springapp.models.Movie;
import org.example.springapp.models.MovieGenre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<Movie> rowMapper = (resultSet, rowNum) -> {
        Movie movie = new Movie();
        movie.setId(resultSet.getLong("id"));
        movie.setTitle(resultSet.getString("title"));
        movie.setGenre(MovieGenre.valueOf(resultSet.getString("genre")));
        movie.setReleaseYear(resultSet.getInt("release_year"));
        return movie;
    };

    public JdbcMovieDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", rowMapper);
    }

    @Override
    public Movie findById(long id) {
        return jdbcTemplate.queryForObject("select * from movies where id = ?", rowMapper, id);
    }

    // TODO: implement the remaining methods

    @Override
    public Movie findByTitleAndReleaseYear(String title, int releaseYear) {
        return null;
    }

    @Override
    public long add(Movie movie) {
        return 0;
    }

    @Override
    public void update(Movie movie) {

    }

    @Override
    public void delete(long id) {

    }
}
