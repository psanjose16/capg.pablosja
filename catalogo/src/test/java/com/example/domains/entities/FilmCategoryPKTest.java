package com.example.domains.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class FilmCategoryPKTest {

    @Test
    void testEquals_SameObject() {
        FilmCategoryPK pk = new FilmCategoryPK();
        pk.setFilmId(1);
        pk.setCategoryId((byte) 2);

        assertTrue(pk.equals(pk));
    }

    @Test
    void testEquals_DifferentObjectSameValues() {
        FilmCategoryPK pk1 = new FilmCategoryPK();
        pk1.setFilmId(1);
        pk1.setCategoryId((byte) 2);

        FilmCategoryPK pk2 = new FilmCategoryPK();
        pk2.setFilmId(1);
        pk2.setCategoryId((byte) 2);

        assertTrue(pk1.equals(pk2));
    }

    @Test
    void testEquals_DifferentValues() {
        FilmCategoryPK pk1 = new FilmCategoryPK();
        pk1.setFilmId(1);
        pk1.setCategoryId((byte) 2);

        FilmCategoryPK pk2 = new FilmCategoryPK();
        pk2.setFilmId(3);
        pk2.setCategoryId((byte) 4);

        assertFalse(pk1.equals(pk2));
    }

    @Test
    void testEquals_NullObject() {
        FilmCategoryPK pk = new FilmCategoryPK();
        pk.setFilmId(1);
        pk.setCategoryId((byte) 2);

        assertFalse(pk.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        FilmCategoryPK pk = new FilmCategoryPK();
        pk.setFilmId(1);
        pk.setCategoryId((byte) 2);

        assertFalse(pk.equals("Some String"));
    }

    @Test
    void testHashCode_SameValues() {
        FilmCategoryPK pk1 = new FilmCategoryPK();
        pk1.setFilmId(1);
        pk1.setCategoryId((byte) 2);

        FilmCategoryPK pk2 = new FilmCategoryPK();
        pk2.setFilmId(1);
        pk2.setCategoryId((byte) 2);

        assertEquals(pk1.hashCode(), pk2.hashCode());
    }

    @Test
    void testHashCode_DifferentValues() {
        FilmCategoryPK pk1 = new FilmCategoryPK();
        pk1.setFilmId(1);
        pk1.setCategoryId((byte) 2);

        FilmCategoryPK pk2 = new FilmCategoryPK();
        pk2.setFilmId(3);
        pk2.setCategoryId((byte) 4);

        assertNotEquals(pk1.hashCode(), pk2.hashCode());
    }
}