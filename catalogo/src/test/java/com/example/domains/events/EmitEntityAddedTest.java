package com.example.domains.events;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.annotation.Annotation;
import org.junit.jupiter.api.Test;






class EmitEntityAddedTest {

    @Test
    void testEmitEntityAddedAnnotation() throws NoSuchMethodException {
        // Retrieve the annotation from a sample method
        class TestClass {
            @EmitEntityAdded(entityName = "TestEntity")
            public void sampleMethod() {
            }
        }

        // Get the annotation
        EmitEntityAdded annotation = TestClass.class
                .getDeclaredMethod("sampleMethod")
                .getAnnotation(EmitEntityAdded.class);

        // Assert the annotation is not null
        assertEquals("TestEntity", annotation.entityName());
    }
}