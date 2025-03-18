package com.example.domains.events;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;





class DomainEventTest {

    @Test
    void testDomainEventCreation() {
        String entity = "TestEntity";
        int pk = 1;
        String property = "TestProperty";
        Object old = "OldValue";
        Object current = "CurrentValue";

        DomainEvent event = new DomainEvent(entity, pk, property, old, current);

        assertEquals(entity, event.entity());
        assertEquals(pk, event.pk());
        assertEquals(property, event.property());
        assertEquals(old, event.old());
        assertEquals(current, event.current());
    }
}