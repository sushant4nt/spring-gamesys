package org.example.bootopenapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song, Long> {
}
