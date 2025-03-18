package com.example.domains.events;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;





class EntityChangedEventTest {

    static class TestEntity {
        @jakarta.persistence.Id
        private int id;

        public TestEntity(int id) {
            this.id = id;
        }
    }

    @Test
    void testAsAdd() {
        TestEntity entity = new TestEntity(1);
        EntityChangedEvent event = EntityChangedEvent.asAdd(entity);

        assertEquals(EntityChangedEvent.Type.ADD, event.type());
        assertEquals("TestEntity", event.entity());
        assertEquals(1, event.key());
    }

    @Test
    void testAsModify() {
        TestEntity entity = new TestEntity(2);
        EntityChangedEvent event = EntityChangedEvent.asModify(entity);

        assertEquals(EntityChangedEvent.Type.MODIFY, event.type());
        assertEquals("TestEntity", event.entity());
        assertEquals(2, event.key());
    }

    @Test
    void testAsRemoveWithEntity() {
        TestEntity entity = new TestEntity(3);
        EntityChangedEvent event = EntityChangedEvent.asRemove(entity);

        assertEquals(EntityChangedEvent.Type.REMOVE, event.type());
        assertEquals("TestEntity", event.entity());
        assertEquals(3, event.key());
    }

    @Test
    void testAsRemoveWithEntityAndKey() {
        TestEntity entity = new TestEntity(4);
        EntityChangedEvent event = EntityChangedEvent.asRemove(entity, 4);

        assertEquals(EntityChangedEvent.Type.REMOVE, event.type());
        assertEquals("TestEntity", event.entity());
        assertEquals(4, event.key());
    }

    @Test
    void testAsRemoveWithEntityNameAndKey() {
        EntityChangedEvent event = EntityChangedEvent.asRemove("CustomEntity", 5);

        assertEquals(EntityChangedEvent.Type.REMOVE, event.type());
        assertEquals("CustomEntity", event.entity());
        assertEquals(5, event.key());
    }

    @Test
    void testAsOthers() {
        TestEntity entity = new TestEntity(6);
        EntityChangedEvent event = EntityChangedEvent.asOthers(entity);

        assertEquals(EntityChangedEvent.Type.OTHERS, event.type());
        assertEquals("TestEntity", event.entity());
        assertEquals(6, event.key());
    }

    @Test
    void testGetIdThrowsExceptionWhenNoIdField() {
        class NoIdEntity {
            private String name;
        }

        NoIdEntity entity = new NoIdEntity();

        Exception exception = assertThrows(org.springframework.data.mapping.MappingException.class, () -> {
            EntityChangedEvent.asAdd(entity);
        });

        assertTrue(exception.getMessage().contains("Entity does not have an id field."));
    }
}