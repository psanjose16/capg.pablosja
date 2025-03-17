package com.example.domains.services;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.entities.Actor;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;





class ActorServiceImplTest {

    @Mock
    private ActorRepository dao;

    @InjectMocks
    private ActorServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<Actor> actors = Arrays.asList(new Actor(1, "John", "Doe"), new Actor(2, "Jane", "Smith"));
        when(dao.findAll()).thenReturn(actors);

        List<Actor> result = service.getAll();

        assertEquals(2, result.size());
        verify(dao).findAll();
    }

    @Test
    void testGetOne() {
        Actor actor = new Actor(1, "John", "Doe");
        when(dao.findById(1)).thenReturn(Optional.of(actor));

        Optional<Actor> result = service.getOne(1);

        assertTrue(result.isPresent());
        assertEquals("John", result.get().getFirstName());
        verify(dao).findById(1);
    }

    @Test
    void testAdd() throws DuplicateKeyException, InvalidDataException {
        Actor actor = new Actor(0, "John", "Doe");
        when(dao.insert(actor)).thenReturn(actor);

        Actor result = service.add(actor);

        assertNotNull(result);
        verify(dao).insert(actor);
    }

    @Test
    void testModify() throws NotFoundException, InvalidDataException {
        Actor actor = new Actor(1, "John", "Doe");
        when(dao.update(actor)).thenReturn(actor);

        Actor result = service.modify(actor);

        assertNotNull(result);
        verify(dao).update(actor);
    }

    @Test
    void testDelete() throws InvalidDataException {
        Actor actor = new Actor(1, "John", "Doe");

        service.delete(actor);

        verify(dao).delete(actor);
    }

    @Test
    void testDeleteById() {
        service.deleteById(1);

        verify(dao).deleteById(1);
    }

    @Test
    void testAwards() {
        List<Actor> actors = Arrays.asList(new Actor(1, "John", "Doe"), new Actor(2, "Jane", "Smith"));
        when(dao.findAll()).thenReturn(actors);

        service.awards();

        for (Actor actor : actors) {
            assertTrue(actor.isAwarded());
        }
        verify(dao, times(2)).save(any(Actor.class));
    }

    @Test
    void testNovedades() {
        Timestamp timestamp = Timestamp.valueOf("2023-01-01 00:00:00");
        List<Actor> actors = Arrays.asList(new Actor(1, "John", "Doe"), new Actor(2, "Jane", "Smith"));
        when(dao.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp)).thenReturn(actors);

        List<Actor> result = service.novedades(timestamp);

        assertEquals(2, result.size());
        verify(dao).findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp);
    }
}