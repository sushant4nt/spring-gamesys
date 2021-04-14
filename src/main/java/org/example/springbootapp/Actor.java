package org.example.springbootapp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Actor {

    private long id;
    private String name;
    private LocalDate dob;
    private String countryOfBirth;
    private boolean active;
    private Set<Movie> movies;

    public Actor(String name, LocalDate dob, String countryOfBirth, boolean active) {
        this.name = name;
        this.dob = dob;
        this.countryOfBirth = countryOfBirth;
        this.active = active;
        this.movies = new HashSet<>();
    }

    public Actor() {
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", active=" + active +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
