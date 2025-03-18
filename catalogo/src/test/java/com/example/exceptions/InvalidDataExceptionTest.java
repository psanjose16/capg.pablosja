package com.example.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;






class InvalidDataExceptionTest {

    @Test
    void testDefaultConstructor() {
        InvalidDataException exception = new InvalidDataException();
        assertEquals("Invalid data", exception.getMessage());
        assertFalse(exception.hasErrors());
    }

    @Test
    void testMessageConstructor() {
        InvalidDataException exception = new InvalidDataException("Custom message");
        assertEquals("Custom message", exception.getMessage());
        assertFalse(exception.hasErrors());
    }

    @Test
    void testErrorsConstructor() {
        Map<String, String> errors = new HashMap<>();
        errors.put("field1", "error1");
        InvalidDataException exception = new InvalidDataException(errors);
        assertEquals("Invalid data", exception.getMessage());
        assertTrue(exception.hasErrors());
        assertEquals(errors, exception.getErrors());
    }

    @Test
    void testMessageAndErrorsConstructor() {
        Map<String, String> errors = new HashMap<>();
        errors.put("field1", "error1");
        InvalidDataException exception = new InvalidDataException("Custom message", errors);
        assertEquals("Custom message", exception.getMessage());
        assertTrue(exception.hasErrors());
        assertEquals(errors, exception.getErrors());
    }

    @Test
    void testCauseConstructor() {
        Throwable cause = new RuntimeException("Cause");
        InvalidDataException exception = new InvalidDataException(cause);
        assertEquals("Invalid data", exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertFalse(exception.hasErrors());
    }

    @Test
    void testMessageAndCauseConstructor() {
        Throwable cause = new RuntimeException("Cause");
        InvalidDataException exception = new InvalidDataException("Custom message", cause);
        assertEquals("Custom message", exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertFalse(exception.hasErrors());
    }

    @Test
    void testMessageCauseAndErrorsConstructor() {
        Throwable cause = new RuntimeException("Cause");
        Map<String, String> errors = new HashMap<>();
        errors.put("field1", "error1");
        InvalidDataException exception = new InvalidDataException("Custom message", cause, errors);
        assertEquals("Custom message", exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertTrue(exception.hasErrors());
        assertEquals(errors, exception.getErrors());
    }

    @Test
    void testFullConstructor() {
        Throwable cause = new RuntimeException("Cause");
        Map<String, String> errors = new HashMap<>();
        errors.put("field1", "error1");
        InvalidDataException exception = new InvalidDataException("Custom message", cause, errors, true, true);
        assertEquals("Custom message", exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertTrue(exception.hasErrors());
        assertEquals(errors, exception.getErrors());
    }
}