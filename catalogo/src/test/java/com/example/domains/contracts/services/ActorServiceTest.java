package com.example.domains.contracts.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.domains.entities.Actor;





class ActorServiceTest {

    @Mock
    private ActorService actorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRepartePremios() {
        doNothing().when(actorService).repartePremios();
        actorService.repartePremios();
        verify(actorService, times(1)).repartePremios();
    }

    @Test
    void testNovedades() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<Actor> expectedActors = Arrays.asList(new Actor(), new Actor());
        when(actorService.novedades(timestamp)).thenReturn(expectedActors);

        List<Actor> result = actorService.novedades(timestamp);

        assertNotNull(result);
        assertEquals(expectedActors.size(), result.size());
        verify(actorService, times(1)).novedades(timestamp);
    }

    @Test
    void testInsert() {
        Actor actor = new Actor();
        when(actorService.insert(actor)).thenReturn(actor);

        Actor result = actorService.insert(actor);

        assertNotNull(result);
        assertEquals(actor, result);
        verify(actorService, times(1)).insert(actor);
    }

    @Test
    void testUpdate() {
        Actor actor = new Actor();
        when(actorService.update(actor)).thenReturn(actor);

        Actor result = actorService.update(actor);

        assertNotNull(result);
        assertEquals(actor, result);
        verify(actorService, times(1)).update(actor);
    }
}