package org.example.bootopenapiclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SongServiceTest {

    @Autowired
    private SongService service;

    @Test
    public void testGetAllSongs() {
        assertEquals(3, service.getAllSongs().size());
    }
}
