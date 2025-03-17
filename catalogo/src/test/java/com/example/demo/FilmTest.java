package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.domains.entities.Film;
import com.example.domains.entities.FilmActor;
import com.example.domains.entities.FilmCategory;
import com.example.domains.entities.Language;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


class FilmTest {

    @Test
    void testFilmConstructorAndGetters() {
        Film film = new Film();
        film.setFilmId(1);
        film.setTitle("Test Title");
        film.setDescription("Test Description");
        film.setLength(120);
        film.setRating("PG");
        film.setReleaseYear((short) 2022);
        film.setRentalDuration((byte) 5);
        film.setRentalRate(new BigDecimal("4.99"));
        film.setReplacementCost(new BigDecimal("19.99"));
        film.setLastUpdate(Timestamp.valueOf("2023-01-01 10:00:00"));

        assertEquals(1, film.getFilmId());
        assertEquals("Test Title", film.getTitle());
        assertEquals("Test Description", film.getDescription());
        assertEquals(120, film.getLength());
        assertEquals("PG", film.getRating());
        assertEquals((short) 2022, film.getReleaseYear());
        assertEquals((byte) 5, film.getRentalDuration());
        assertEquals(new BigDecimal("4.99"), film.getRentalRate());
        assertEquals(new BigDecimal("19.99"), film.getReplacementCost());
        assertEquals(Timestamp.valueOf("2023-01-01 10:00:00"), film.getLastUpdate());
    }

    @Test
    void testAddAndRemoveFilmActor() {
        Film film = new Film();
        FilmActor actor = new FilmActor();
        actor.setFilm(film);

        film.setFilmActors(new ArrayList<>());
        film.addFilmActor(actor);

        assertEquals(1, film.getFilmActors().size());
        assertEquals(film, film.getFilmActors().get(0).getFilm());

        film.removeFilmActor(actor);
        assertTrue(film.getFilmActors().isEmpty());
    }

    @Test
    void testAddAndRemoveFilmCategory() {
        Film film = new Film();
        FilmCategory category = new FilmCategory();
        category.setFilm(film);

        film.setFilmCategories(new ArrayList<>());
        film.addFilmCategory(category);

        assertEquals(1, film.getFilmCategories().size());
        assertEquals(film, film.getFilmCategories().get(0).getFilm());

        film.removeFilmCategory(category);
        assertTrue(film.getFilmCategories().isEmpty());
    }

    @Test
    void testSetAndGetLanguage() {
        Film film = new Film();
        Language language = new Language();
        language.setLanguageId(1);

        film.setLanguage(language);
        assertEquals(language, film.getLanguage());
    }

    @Test
    void testSetAndGetLanguageVO() {
        Film film = new Film();
        Language languageVO = new Language();
        languageVO.setLanguageId(2);

        film.setLanguageVO(languageVO);
        assertEquals(languageVO, film.getLanguageVO());
    }
}