package org.example.springbootapp;

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
                new Song("Run to the Hills", "Iron Maiden", SongGenre.METAL),
                new Song("As I Am", "Dream Theatre", SongGenre.METAL),
                new Song("Hammer Smash Face", "Cannibal Corpse", SongGenre.METAL)
        ));
    }
}
