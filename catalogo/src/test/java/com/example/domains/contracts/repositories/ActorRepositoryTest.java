package com.example.domains.contracts.repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.sql.Timestamp;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.domains.entities.Actor;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.NotFoundException;





class ActorRepositoryTest {

    @Mock
    private ActorRepository actorRepository;

    @InjectMocks
    private ActorRepositoryTest actorRepositoryTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInsert_Success() throws DuplicateKeyException {
        Actor actor = new Actor();
        actor.setActorId(1);

        when(actorRepository.existsById(actor.getActorId())).thenReturn(false);
        when(actorRepository.save(actor)).thenReturn(actor);

        Actor result = actorRepository.insert(actor);

        assertNotNull(result);
        assertEquals(actor, result);
        verify(actorRepository).existsById(actor.getActorId());
        verify(actorRepository).save(actor);
    }

    @Test
    void testInsert_DuplicateKeyException() {
        Actor actor = new Actor();
        actor.setActorId(1);

        when(actorRepository.existsById(actor.getActorId())).thenReturn(true);

        assertThrows(DuplicateKeyException.class, () -> actorRepository.insert(actor));
        verify(actorRepository).existsById(actor.getActorId());
        verify(actorRepository, never()).save(actor);
    }

    @Test
    void testUpdate_Success() throws NotFoundException {
        Actor actor = new Actor();
        actor.setActorId(1);

        when(actorRepository.existsById(actor.getActorId())).thenReturn(true);
        when(actorRepository.save(actor)).thenReturn(actor);

        Actor result = actorRepository.update(actor);

        assertNotNull(result);
        assertEquals(actor, result);
        verify(actorRepository).existsById(actor.getActorId());
        verify(actorRepository).save(actor);
    }

    @Test
    void testUpdate_NotFoundException() {
        Actor actor = new Actor();
        actor.setActorId(1);

        when(actorRepository.existsById(actor.getActorId())).thenReturn(false);

        assertThrows(NotFoundException.class, () -> actorRepository.update(actor));
        verify(actorRepository).existsById(actor.getActorId());
        verify(actorRepository, never()).save(actor);
    }
}