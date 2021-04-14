package org.example.springapp;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContextTestConfig {

    @Bean
    public Repo repo() {
        return Mockito.mock(Repo.class);
    }
}
