package com.example.domains.events;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;





@EntityName(name = "TestEntity")
class EntityNameTest {

    @Test
    void testEntityNameAnnotation() {
        EntityName annotation = this.getClass().getAnnotation(EntityName.class);
        assertEquals("TestEntity", annotation.name(), "The name attribute of the EntityName annotation should match.");
    }
}