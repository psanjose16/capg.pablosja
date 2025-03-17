package com.example.domains.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;


class FilmCategoryTest {

    @Test
    void testGettersAndSetters() {
        FilmCategory filmCategory = new FilmCategory();
        FilmCategoryPK id = new FilmCategoryPK();
        Timestamp lastUpdate = new Timestamp(System.currentTimeMillis());
        Category category = new Category();
        Film film = new Film();

        filmCategory.setId(id);
        filmCategory.setLastUpdate(lastUpdate);
        filmCategory.setCategory(category);
        filmCategory.setFilm(film);

        assertEquals(id, filmCategory.getId());
        assertEquals(lastUpdate, filmCategory.getLastUpdate());
        assertEquals(category, filmCategory.getCategory());
        assertEquals(film, filmCategory.getFilm());
    }

    @Test
    void testDefaultConstructor() {
        FilmCategory filmCategory = new FilmCategory();
        assertNotNull(filmCategory);
        assertNull(filmCategory.getId());
        assertNull(filmCategory.getLastUpdate());
        assertNull(filmCategory.getCategory());
        assertNull(filmCategory.getFilm());
    }
}
