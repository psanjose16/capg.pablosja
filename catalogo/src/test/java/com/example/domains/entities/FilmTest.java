package com.example.domains.entities;

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
        assertEquals(film, ((FilmActor) film.getFilmActors().get(0)).getFilm());

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
        assertEquals(film, ((FilmCategory) film.getFilmCategories().get(0)).getFilm());

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

    @Test
    void testAddAndRemoveSpecialFeatures() {
        Film film = new Film();
        film.addSpecialFeatures(Film.SpecialFeature.Trailers);
        film.addSpecialFeatures(Film.SpecialFeature.Commentaries);

        List<Film.SpecialFeature> specialFeatures = film.getSpecialFeatures();
        assertTrue(specialFeatures.contains(Film.SpecialFeature.Trailers));
        assertTrue(specialFeatures.contains(Film.SpecialFeature.Commentaries));

        film.removeSpecialFeatures(Film.SpecialFeature.Trailers);
        specialFeatures = film.getSpecialFeatures();
        assertFalse(specialFeatures.contains(Film.SpecialFeature.Trailers));
        assertTrue(specialFeatures.contains(Film.SpecialFeature.Commentaries));
    }

    @Test
    void testMerge() {
        Film source = new Film();
        source.setTitle("Source Title");
        source.setDescription("Source Description");
        source.setReleaseYear((short) 2020);
        source.setRentalDuration((byte) 3);
        source.setRentalRate(new BigDecimal("3.99"));
        source.setReplacementCost(new BigDecimal("15.99"));
        source.setLength(100);
        source.setRating(Film.Rating.PARENTAL_GUIDANCE_SUGGESTED);
        source.addSpecialFeatures(Film.SpecialFeature.Trailers);

        Film target = new Film();
        target.setTitle("Target Title");
        target.setDescription("Target Description");
        target.setReleaseYear((short) 2019);
        target.setRentalDuration((byte) 2);
        target.setRentalRate(new BigDecimal("2.99"));
        target.setReplacementCost(new BigDecimal("10.99"));
        target.setLength(90);
        target.setRating(Film.Rating.GENERAL_AUDIENCES);

        source.merge(target);

        assertEquals("Source Title", target.getTitle());
        assertEquals("Source Description", target.getDescription());
        assertEquals((short) 2020, target.getReleaseYear());
        assertEquals((byte) 3, target.getRentalDuration());
        assertEquals(new BigDecimal("3.99"), target.getRentalRate());
        assertEquals(new BigDecimal("15.99"), target.getReplacementCost());
        assertEquals(100, target.getLength());
        assertEquals(Film.Rating.PARENTAL_GUIDANCE_SUGGESTED, target.getRating());
        assertTrue(target.getSpecialFeatures().contains(Film.SpecialFeature.Trailers));
    }

    @Test
    void testClearActors() {
        Film film = new Film();
        film.addActor(new Actor(1));
        film.addActor(new Actor(2));

        assertEquals(2, film.getActors().size());

        film.clearActors();
        assertTrue(film.getActors().isEmpty());
    }

    @Test
    void testClearCategories() {
        Film film = new Film();
        film.addCategory(new Category(1));
        film.addCategory(new Category(2));

        assertEquals(2, film.getCategories().size());

        film.clearCategories();
        assertTrue(film.getCategories().isEmpty());
    }

    @Test
    void testSetAndGetDescription() {
        Film film = new Film();
        film.setDescription("A great movie");
        assertEquals("A great movie", film.getDescription());
    }

    @Test
    void testSetAndGetLastUpdate() {
        Film film = new Film();
        Timestamp timestamp = Timestamp.valueOf("2023-01-01 10:00:00");
        film.setLastUpdate(timestamp);
        assertEquals(timestamp, film.getLastUpdate());
    }

    @Test
    void testSetAndGetLength() {
        Film film = new Film();
        film.setLength(120);
        assertEquals(120, film.getLength());
    }

    @Test
    void testSetAndGetReleaseYear() {
        Film film = new Film();
        film.setReleaseYear((short) 2022);
        assertEquals((short) 2022, film.getReleaseYear());
    }

    @Test
    void testSetAndGetRentalDuration() {
        Film film = new Film();
        film.setRentalDuration((byte) 5);
        assertEquals((byte) 5, film.getRentalDuration());
    }

    @Test
    void testSetAndGetRentalRate() {
        Film film = new Film();
        BigDecimal rentalRate = new BigDecimal("4.99");
        film.setRentalRate(rentalRate);
        assertEquals(rentalRate, film.getRentalRate());
    }

    @Test
    void testSetAndGetReplacementCost() {
        Film film = new Film();
        BigDecimal replacementCost = new BigDecimal("19.99");
        film.setReplacementCost(replacementCost);
        assertEquals(replacementCost, film.getReplacementCost());
    }

    @Test
    void testSetAndGetTitle() {
        Film film = new Film();
        film.setTitle("Test Title");
        assertEquals("Test Title", film.getTitle());
    }

    @Test
    void testSetAndGetRating() {
        Film film = new Film();
        Film.Rating rating = Film.Rating.PARENTAL_GUIDANCE_SUGGESTED;
        film.setRating(rating);
        assertEquals(rating, film.getRating());
    }

    @Test
    void testAddAndRemoveActor() {
        Film film = new Film();
        Actor actor = new Actor(1);

        film.addActor(actor);
        assertTrue(film.getActors().contains(actor));

        film.removeActor(actor);
        assertFalse(film.getActors().contains(actor));
    }

    @Test
    void testAddAndRemoveCategory() {
        Film film = new Film();
        Category category = new Category(1);

        film.addCategory(category);
        assertTrue(film.getCategories().contains(category));

        film.removeCategory(category);
        assertFalse(film.getCategories().contains(category));
    }
}