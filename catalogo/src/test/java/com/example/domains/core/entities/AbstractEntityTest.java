package com.example.domains.core.entities;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AbstractEntityTest {

    private AbstractEntity<TestEntity> abstractEntity;
    @BeforeEach
    void setUp() {
        abstractEntity = new TestEntity();
    }

    @Test
    void testIsValid() {
        assertTrue(abstractEntity.isValid());
    }

    @Test
    void testIsInvalid() {
        ((TestEntity) abstractEntity).setName(null); // Invalid state
        assertTrue(abstractEntity.isInvalid());
    }

    @Test
    void testGetErrors() {
        ((TestEntity) abstractEntity).setName(null); // Invalid state
        Set<ConstraintViolation<TestEntity>> errors = abstractEntity.getErrors();
        assertFalse(errors.isEmpty());
    }

    @Test
    void testGetErrorsFields() {
        ((TestEntity) abstractEntity).setName(null); // Invalid state
        Map<String, String> errorsFields = abstractEntity.getErrorsFields();
        assertNotNull(errorsFields);
        assertTrue(errorsFields.containsKey("name"));
    }

    @Test
    void testGetErrorsMessage() {
        ((TestEntity) abstractEntity).setName(null); // Invalid state
        String errorsMessage = abstractEntity.getErrorsMessage();
        assertNotNull(errorsMessage);
        assertTrue(errorsMessage.contains("name"));
    }

    // A simple concrete implementation of AbstractEntity for testing purposes
    private class TestEntity extends AbstractEntity<TestEntity> {
        @jakarta.validation.constraints.NotNull
        private String name = "Test";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    
        @Test
        void testGetName() {
            assertEquals("Test", ((TestEntity) abstractEntity).getName());
        }
    }
}