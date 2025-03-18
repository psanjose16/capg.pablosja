package com.example.domains.events;

import static org.mockito.Mockito.*;
import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;





class EntityChangedEventAspectTest {

    @InjectMocks
    private EntityChangedEventAspect aspect;

    @Mock
    private ApplicationEventPublisher publisher;

    @Mock
    private JoinPoint joinPoint;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdd() {
        Object entity = new Object();
        when(joinPoint.getArgs()).thenReturn(new Object[]{entity});

        aspect.add(joinPoint, entity);

        verify(publisher).publishEvent(EntityChangedEvent.asAdd(entity));
    }

    @Test
    void testModify() {
        Object entity = new Object();
        when(joinPoint.getArgs()).thenReturn(new Object[]{entity});

        aspect.modify(joinPoint, entity);

        verify(publisher).publishEvent(EntityChangedEvent.asModify(entity));
    }

    @Test
    void testDelete() {
        Object entity = new Object();
        when(joinPoint.getArgs()).thenReturn(new Object[]{entity});

        aspect.delete(joinPoint, entity);

        verify(publisher).publishEvent(EntityChangedEvent.asRemove(entity));
    }

    @Test
    void testDeleteById() {
        Object id = 1;
        when(joinPoint.getArgs()).thenReturn(new Object[]{id});
        when(joinPoint.getTarget()).thenReturn(new Object());
        when(joinPoint.getSignature()).thenReturn(mock(org.aspectj.lang.Signature.class));

        aspect.deleteById(joinPoint);

        verify(publisher).publishEvent(any(EntityChangedEvent.class));
    }
}