package com.example.domains.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.domains.entities.Actor;
import com.example.domains.entities.Film;
import com.example.domains.entities.FilmActor;
import com.example.domains.entities.FilmActorPK;

import java.sql.Timestamp;


class FilmActorTest {

    @Test
    void testFilmActorGettersAndSetters() {
        FilmActor filmActor = new FilmActor();
        FilmActorPK id = new FilmActorPK();
        Timestamp lastUpdate = new Timestamp(System.currentTimeMillis());
        Actor actor = new Actor();
        Film film = new Film();

        filmActor.setId(id);
        filmActor.setLastUpdate(lastUpdate);
        filmActor.setActor(actor);
        filmActor.setFilm(film);

        assertEquals(id, filmActor.getId());
        assertEquals(lastUpdate, filmActor.getLastUpdate());
        assertEquals(actor, filmActor.getActor());
        assertEquals(film, filmActor.getFilm());
    }

    @Test
    void testFilmActorDefaultConstructor() {
        FilmActor filmActor = new FilmActor();
        assertNotNull(filmActor);
        assertNull(filmActor.getId());
        assertNull(filmActor.getLastUpdate());
        assertNull(filmActor.getActor());
        assertNull(filmActor.getFilm());
    }
}