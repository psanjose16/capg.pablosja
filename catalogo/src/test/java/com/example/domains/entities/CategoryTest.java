package com.example.domains.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.domains.entities.Category;
import com.example.domains.entities.FilmCategory;

import java.sql.Timestamp;
import java.util.ArrayList;


class CategoryTest {

    @Test
    void testCategoryConstructorAndGetters() {
        Category category = new Category();
        assertNotNull(category);
        assertEquals(0, category.getCategoryId());
        assertNull(category.getName());
        assertNull(category.getLastUpdate());
        assertNull(category.getFilmCategories());
    }

    @Test
    void testSettersAndGetters() {
        Category category = new Category();
        category.setCategoryId(1);
        category.setName("Action");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        category.setLastUpdate(timestamp);
        category.setFilmCategories(new ArrayList<>());

        assertEquals(1, category.getCategoryId());
        assertEquals("Action", category.getName());
        assertEquals(timestamp, category.getLastUpdate());
        assertNotNull(category.getFilmCategories());
    }

    @Test
    void testAddFilmCategory() {
        Category category = new Category();
        category.setFilmCategories(new ArrayList<>());
        FilmCategory filmCategory = new FilmCategory();
        category.addFilmCategory(filmCategory);

        assertEquals(1, category.getFilmCategories().size());
        assertEquals(category, filmCategory.getCategory());
    }

    @Test
    void testRemoveFilmCategory() {
        Category category = new Category();
        category.setFilmCategories(new ArrayList<>());
        FilmCategory filmCategory = new FilmCategory();
        category.addFilmCategory(filmCategory);

        category.removeFilmCategory(filmCategory);

        assertEquals(0, category.getFilmCategories().size());
        assertNull(filmCategory.getCategory());
    }
}