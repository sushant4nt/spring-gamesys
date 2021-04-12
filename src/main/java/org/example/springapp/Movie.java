package org.example.springapp;

import java.util.Objects;

public class Movie {

    private long id;
    private String title;
    private MovieGenre genre;
    private int releaseYear;

    private static long nextId = 1;

    public Movie(String title, MovieGenre genre, int releaseYear) {
        this.id = nextId++;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return releaseYear == movie.releaseYear && title.equals(movie.title) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, releaseYear);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", releaseYear=" + releaseYear +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
