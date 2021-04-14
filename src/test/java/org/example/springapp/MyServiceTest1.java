package org.example.springapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppContextConfig.class)
public class MyServiceTest1 {

    // This is NOT an integration so is the IoC container really needed?

    @Configuration
    public static class Config {

        @Primary
        @Bean
        public Repo mockRepo() {
            return mock(Repo.class);
        }
    }

    @Autowired
    private MyService service;

    @Autowired
    private Repo mockRepo;

    @Test
    public void testGetSomeData() {
        when(mockRepo.getSomeData()).thenReturn("data");
        assertEquals("From service: data", service.getSomeData());
        verify(mockRepo).getSomeData();
    }
}
