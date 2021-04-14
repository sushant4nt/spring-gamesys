package org.example.springbootapp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String title;

    @NotBlank
    private String artist;

    @Enumerated(EnumType.STRING)
    private SongGenre genre;

    public Song(String title, String artist, SongGenre genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public Song() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public SongGenre getGenre() {
        return genre;
    }

    public void setGenre(SongGenre genre) {
        this.genre = genre;
    }
}
