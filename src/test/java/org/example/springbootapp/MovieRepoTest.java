package org.example.springbootapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MovieRepoTest {

    @Autowired
    private MovieRepo repo;

    @Test
    public void testFindAll() {
        assertEquals(10, repo.findAll().size());
    }
}
