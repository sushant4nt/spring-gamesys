package org.example.bootopenapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private SongRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repo.saveAll(Arrays.asList(
                new Song("Texas Flood", "SRV", "Blues"),
                new Song("Honey Hush", "Albert Collins", "Blues"),
                new Song("Manish Boy", "Muddy Waters", "Blues")
        ));
    }
}
