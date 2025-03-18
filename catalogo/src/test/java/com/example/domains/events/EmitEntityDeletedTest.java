package com.example.domains.events;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.annotation.Annotation;
import org.junit.jupiter.api.Test;






class EmitEntityDeletedTest {

    @Test
    void testEmitEntityDeletedAnnotation() {
        // Retrieve the annotation
        EmitEntityDeleted annotation = new EmitEntityDeleted() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return EmitEntityDeleted.class;
            }

            @Override
            public String entityName() {
                return "TestEntity";
            }
        };

        // Verify the entityName value
        assertEquals("TestEntity", annotation.entityName());
    }
}