package org.example.springbootapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Transactional
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testGetAllSongs() throws Exception {
        mockMvc.perform(get("/songs").accept(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testAddValidSong() throws Exception {
        Song validSong = new Song("Money for Nothing", "Dire Straits", SongGenre.ROCK);
        String serialisedSong = mapper.writeValueAsString(validSong);
        mockMvc.perform(post("/songs")
                    .contentType(APPLICATION_JSON_VALUE)
                    .content(serialisedSong))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(4)));
    }

    // TODO: add tests for the other endpoints
}
