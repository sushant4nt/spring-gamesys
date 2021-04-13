package org.example.springapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContextConfig {

    @Bean
    public MovieDao inMemoryMovieDao() {
        return new InMemoryMovieDao();
    }

    @Bean
    public MovieDao jdbcMovieDao() {
        return new JdbcMovieDao();
    }
}
