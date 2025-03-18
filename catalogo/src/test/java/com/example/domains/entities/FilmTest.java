package com.example.domains.entities;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class FilmTest {

    private Film film;
    private Language language;

    @BeforeEach
    void setUp() {
        language = new Language(1, "English");
        film = new Film("Test Title", language, (byte) 5, new BigDecimal("2.99"), new BigDecimal("19.99"));
    }

    @Test
    void testFilmConstructor() {
        assertEquals("Test Title", film.getTitle());
        assertEquals(language, film.getLanguage());
        assertEquals(5, film.getRentalDuration());
        assertEquals(new BigDecimal("2.99"), film.getRentalRate());
        assertEquals(new BigDecimal("19.99"), film.getReplacementCost());
    }

    @Test
    void testSetAndGetDescription() {
        film.setDescription("Test Description");
        assertEquals("Test Description", film.getDescription());
    }

    @Test
    void testSetAndGetLength() {
        film.setLength(120);
        assertEquals(120, film.getLength());
    }

    @Test
    void testSetAndGetRating() {
        film.setRating(Film.Rating.GENERAL_AUDIENCES);
        assertEquals(Film.Rating.GENERAL_AUDIENCES, film.getRating());
    }

    @Test
    void testSetAndGetReleaseYear() {
        film.setReleaseYear((short) 2023);
        assertEquals(2023, film.getReleaseYear());
    }

    @Test
    void testAddAndRemoveActor() {
        Actor actor = new Actor(1, "John", "Doe");
        film.addActor(actor);
        assertTrue(film.getActors().contains(actor));

        film.removeActor(actor);
        assertFalse(film.getActors().contains(actor));
    }

    @Test
    void testAddAndRemoveCategory() {
        Category category = new Category(1, "Action");
        film.addCategory(category);
        assertTrue(film.getCategories().contains(category));

        film.removeCategory(category);
        assertFalse(film.getCategories().contains(category));
    }

    @Test
    void testAddAndRemoveSpecialFeatures() {
        film.addSpecialFeatures(Film.SpecialFeature.Trailers);
        assertTrue(film.getSpecialFeatures().contains(Film.SpecialFeature.Trailers));

        film.removeSpecialFeatures(Film.SpecialFeature.Trailers);
        assertFalse(film.getSpecialFeatures().contains(Film.SpecialFeature.Trailers));
    }

    @Test
    void testMerge() {
        Film target = new Film("Target Title", language, (byte) 3, new BigDecimal("1.99"), new BigDecimal("9.99"));
        film.setDescription("Test Description");
        film.setLength(120);
        film.setRating(Film.Rating.RESTRICTED);
        film.setReleaseYear((short) 2023);
        film.addSpecialFeatures(Film.SpecialFeature.Commentaries);

        film.merge(target);

        assertEquals(film.getTitle(), target.getTitle());
        assertEquals(film.getDescription(), target.getDescription());
        assertEquals(film.getLength(), target.getLength());
        assertEquals(film.getRating(), target.getRating());
        assertEquals(film.getReleaseYear(), target.getReleaseYear());
        assertEquals(film.getSpecialFeatures(), target.getSpecialFeatures());
    }

    @Test
    void testSpecialFeatureConverter() {
        Set<Film.SpecialFeature> features = EnumSet.of(Film.SpecialFeature.Trailers, Film.SpecialFeature.Commentaries);
        Film.SpecialFeatureConverter converter = new Film.SpecialFeatureConverter();

        String dbValue = converter.convertToDatabaseColumn(features);
        assertEquals("Trailers,Commentaries", dbValue);

        Set<Film.SpecialFeature> convertedFeatures = converter.convertToEntityAttribute(dbValue);
        assertEquals(features, convertedFeatures);
    }

    @Test
    void testRatingConverter() {
        Film.RatingConverter converter = new Film.RatingConverter();

        String dbValue = converter.convertToDatabaseColumn(Film.Rating.GENERAL_AUDIENCES);
        assertEquals("G", dbValue);

        Film.Rating rating = converter.convertToEntityAttribute("G");
        assertEquals(Film.Rating.GENERAL_AUDIENCES, rating);
    }
}