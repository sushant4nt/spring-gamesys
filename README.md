## Spring Data JPA and or Querydsl

Create a Spring Boot app that includes a Repo of some description 
for the persistence of Albums. 

Each Album has a String artist, int releaseYear, Genre genre, and a 
collection of Tracks.

Each Track has a String title, double duration, and boolean live.

The relationship between Album and Track in the DB is one-to-many.

I'd like to be able to get all Albums by artist, by releaseYear, by genre.
I'd also like to be able to get all Tracks for a given Album.