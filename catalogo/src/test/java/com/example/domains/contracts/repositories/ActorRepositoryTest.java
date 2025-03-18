package com.example.domains.contracts.repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.domains.entities.Actor;
import com.example.domains.repositories.ActorRepositoryImpl;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.NotFoundException;

class ActorRepositoryTest {

    @Mock
    private ActorRepository actorRepository;

    @InjectMocks
    private ActorRepositoryImpl actorRepositoryImpl = new ActorRepositoryImpl(actorRepository);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByLastUpdateGreaterThanEqualOrderByLastUpdate() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Actor actor1 = new Actor(1, "John", "Doe", timestamp);
        Actor actor2 = new Actor(2, "Jane", "Doe", timestamp);
        List<Actor> actors = Arrays.asList(actor1, actor2);

        when(actorRepository.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp)).thenReturn(actors);

        List<Actor> result = actorRepositoryImpl.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp);
        assertEquals(2, result.size());
        assertEquals(actor1, result.get(0));
        assertEquals(actor2, result.get(1));
    }

    @Test
    void testInsert() throws DuplicateKeyException {
        Actor actor = new Actor(1, "John", "Doe", new Timestamp(System.currentTimeMillis()));

        when(actorRepository.existsById(actor.getActorId())).thenReturn(false);
        when(actorRepository.save(actor)).thenReturn(actor);

        Actor result = actorRepositoryImpl.insert(actor);
        assertEquals(actor, result);
    }

    @Test
    void testInsertDuplicateKeyException() {
        Actor actor = new Actor(1, "John", "Doe", new Timestamp(System.currentTimeMillis()));

        when(actorRepository.existsById(actor.getActorId())).thenReturn(true);

        assertThrows(DuplicateKeyException.class, () -> actorRepositoryImpl.insert(actor));
    }

    @Test
    void testUpdate() throws NotFoundException {
        Actor actor = new Actor(1, "John", "Doe", new Timestamp(System.currentTimeMillis()));

        when(actorRepository.existsById(actor.getActorId())).thenReturn(true);
        when(actorRepository.save(actor)).thenReturn(actor);

        Actor result = actorRepositoryImpl.update(actor);
        assertEquals(actor, result);
    }

    @Test
    void testUpdateNotFoundException() {
        Actor actor = new Actor(1, "John", "Doe", new Timestamp(System.currentTimeMillis()));

        when(actorRepository.existsById(actor.getActorId())).thenReturn(false);

        assertThrows(NotFoundException.class, () -> actorRepositoryImpl.update(actor));
    }
}