package com.example.domains.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class FilmActorPKTest {

    @Test
    void testEquals_SameObject() {
        FilmActorPK pk1 = new FilmActorPK();
        pk1.setActorId(1);
        pk1.setFilmId(2);

        assertTrue(pk1.equals(pk1));
    }

    @Test
    void testEquals_DifferentObjectSameValues() {
        FilmActorPK pk1 = new FilmActorPK();
        pk1.setActorId(1);
        pk1.setFilmId(2);

        FilmActorPK pk2 = new FilmActorPK();
        pk2.setActorId(1);
        pk2.setFilmId(2);

        assertTrue(pk1.equals(pk2));
    }

    @Test
    void testEquals_DifferentObjectDifferentValues() {
        FilmActorPK pk1 = new FilmActorPK();
        pk1.setActorId(1);
        pk1.setFilmId(2);

        FilmActorPK pk2 = new FilmActorPK();
        pk2.setActorId(3);
        pk2.setFilmId(4);

        assertFalse(pk1.equals(pk2));
    }

    @Test
    void testEquals_NullObject() {
        FilmActorPK pk1 = new FilmActorPK();
        pk1.setActorId(1);
        pk1.setFilmId(2);

        assertFalse(pk1.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        FilmActorPK pk1 = new FilmActorPK();
        pk1.setActorId(1);
        pk1.setFilmId(2);

        Object obj = new Object();

        assertFalse(pk1.equals(obj));
    }

    @Test
    void testHashCode_SameValues() {
        FilmActorPK pk1 = new FilmActorPK();
        pk1.setActorId(1);
        pk1.setFilmId(2);

        FilmActorPK pk2 = new FilmActorPK();
        pk2.setActorId(1);
        pk2.setFilmId(2);

        assertEquals(pk1.hashCode(), pk2.hashCode());
    }

    @Test
    void testHashCode_DifferentValues() {
        FilmActorPK pk1 = new FilmActorPK();
        pk1.setActorId(1);
        pk1.setFilmId(2);

        FilmActorPK pk2 = new FilmActorPK();
        pk2.setActorId(3);
        pk2.setFilmId(4);

        assertNotEquals(pk1.hashCode(), pk2.hashCode());
    }
}