package org.example.springapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContextConfig {

    @Bean
    public MovieDao movieDao() {
        return new MovieDao();
    }
}
