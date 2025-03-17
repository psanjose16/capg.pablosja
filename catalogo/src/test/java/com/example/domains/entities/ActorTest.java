package com.example.domains.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.domains.entities.Actor;
import com.example.domains.entities.FilmActor;

import java.sql.Timestamp;
import java.util.ArrayList;


class ActorTest {

    @Test
    void testConstructorAndGetters() {
        Actor actor = new Actor(1, "John", "Doe");
        assertEquals(1, actor.getActorId());
        assertEquals("John", actor.getFirstName());
        assertEquals("Doe", actor.getLastName());
    }

    @Test
    void testSetters() {
        Actor actor = new Actor();
        actor.setActorId(2);
        actor.setFirstName("Jane");
        actor.setLastName("Smith");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        actor.setLastUpdate(timestamp);

        assertEquals(2, actor.getActorId());
        assertEquals("Jane", actor.getFirstName());
        assertEquals("Smith", actor.getLastName());
        assertEquals(timestamp, actor.getLastUpdate());
    }

    @Test
    void testAddAndRemoveFilmActor() {
        Actor actor = new Actor(1, "John", "Doe");
        FilmActor filmActor = new FilmActor();
        filmActor.setActor(actor);

        actor.setFilmActors(new ArrayList<>());
        actor.addFilmActor(filmActor);

        assertTrue(actor.getFilmActors().contains(filmActor));
        assertEquals(actor, filmActor.getActor());

        actor.removeFilmActor(filmActor);
        assertFalse(actor.getFilmActors().contains(filmActor));
        assertNull(filmActor.getActor());
    }

    @Test
    void testEqualsAndHashCode() {
        Actor actor1 = new Actor(1, "John", "Doe");
        Actor actor2 = new Actor(1, "John", "Doe");
        Actor actor3 = new Actor(2, "Jane", "Smith");

        assertEquals(actor1, actor2);
        assertNotEquals(actor1, actor3);
        assertEquals(actor1.hashCode(), actor2.hashCode());
        assertNotEquals(actor1.hashCode(), actor3.hashCode());
    }

    @Test
    void testToString() {
        Actor actor = new Actor(1, "John", "Doe");
        String expected = "Actor [actorId=1, firstName=John, lastName=Doe, lastUpdate=null]";
        assertEquals(expected, actor.toString());
    }
}