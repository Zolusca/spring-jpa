package org.zolusca.inc.Testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zolusca.inc.Entities.Film;
import org.zolusca.inc.Entities.Genre;
import org.zolusca.inc.Repository.FilmRepository;
import org.zolusca.inc.Repository.GenreRepository;

import java.util.Optional;

@SpringBootTest
public class OneToMany {
    @Autowired private FilmRepository filmRepository;
    @Autowired private GenreRepository genreRepository;

    private final String GENRE = "HOROR";
    private final String FILM = "HARGA_CABAI_NAIK";

    @Test
    @Order(1)
    void insertGenre(){
        Genre horor = new Genre();
        horor.setName(GENRE);

        genreRepository.save(horor);
    }

    @Test
    @Order(2)
    void findGenre(){
        Optional<Genre> genre = genreRepository.findByName(GENRE);

        System.out.println(genre.get().getName());
        System.out.println(genre.get().getFilms().get(0).getName());
        Assertions.assertNotNull(genre.get());
    }

    @Test
    @Order(3)
    void deleteGenre(){
        Optional<Genre> genre = genreRepository.findByName(GENRE);
        genreRepository.delete(genre.get());
    }

    @Test
    @Order(4)
    void insertFilm(){
        Genre horor = new Genre();
        horor.setName(GENRE);

        Film filmHoror = new Film();
        filmHoror.setName(FILM);
        filmHoror.setGenre(horor);

        filmRepository.save(filmHoror);
    }

    @Test
    void findGenreWithFilm(){
        Optional<Genre> genre = genreRepository.findByName(GENRE);

        System.out.println(genre.get().getName());
        System.out.println(genre.get().getFilms().get(0).getName());

        Assertions.assertNotNull(genre.get());
    }
}
