package com.example.domains.events;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.annotation.Annotation;
import org.junit.jupiter.api.Test;






class EmitEntityModifiedTest {

    @Test
    void testEmitEntityModifiedAnnotation() throws NoSuchMethodException {
        // Retrieve the annotation from a sample method
        class TestClass {
            @EmitEntityModified(entityName = "TestEntity")
            public void sampleMethod() {}
        }

        // Get the annotation
        Annotation annotation = TestClass.class.getMethod("sampleMethod").getAnnotation(EmitEntityModified.class);

        // Assert that the annotation is present
        assertEquals(true, annotation instanceof EmitEntityModified);

        // Assert the entityName value
        EmitEntityModified emitEntityModified = (EmitEntityModified) annotation;
        assertEquals("TestEntity", emitEntityModified.entityName());
    }
}