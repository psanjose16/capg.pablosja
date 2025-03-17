package com.example.domains.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.util.ArrayList;


class LanguageTest {

    @Test
    void testLanguageConstructor() {
        Language language = new Language();
        assertNotNull(language);
    }

    @Test
    void testGettersAndSetters() {
        Language language = new Language();
        language.setLanguageId(1);
        language.setName("English");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        language.setLastUpdate(timestamp);

        assertEquals(1, language.getLanguageId());
        assertEquals("English", language.getName());
        assertEquals(timestamp, language.getLastUpdate());
    }

    @Test
    void testAddAndRemoveFilm() {
        Language language = new Language();
        Film film = new Film();
        language.setFilms(new ArrayList<>());

        language.addFilm(film);
        assertTrue(language.getFilms().contains(film));
        assertEquals(language, film.getLanguage());

        language.removeFilm(film);
        assertFalse(language.getFilms().contains(film));
        assertNull(film.getLanguage());
    }

    @Test
    void testAddAndRemoveFilmsVO() {
        Language language = new Language();
        Film filmVO = new Film();
        language.setFilmsVO(new ArrayList<>());

        language.addFilmsVO(filmVO);
        assertTrue(language.getFilmsVO().contains(filmVO));
        assertEquals(language, filmVO.getLanguageVO());

        language.removeFilmsVO(filmVO);
        assertFalse(language.getFilmsVO().contains(filmVO));
        assertNull(filmVO.getLanguageVO());
    }
}