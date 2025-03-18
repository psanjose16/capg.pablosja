package com.example.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;





class DuplicateKeyExceptionTest {

    @Test
    void testDefaultConstructor() {
        DuplicateKeyException exception = new DuplicateKeyException();
        assertEquals("Duplicate key", exception.getMessage());
    }

    @Test
    void testConstructorWithMessage() {
        String customMessage = "Custom message";
        DuplicateKeyException exception = new DuplicateKeyException(customMessage);
        assertEquals(customMessage, exception.getMessage());
    }

    @Test
    void testConstructorWithCause() {
        Throwable cause = new RuntimeException("Cause");
        DuplicateKeyException exception = new DuplicateKeyException(cause);
        assertEquals("Duplicate key", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        String customMessage = "Custom message";
        Throwable cause = new RuntimeException("Cause");
        DuplicateKeyException exception = new DuplicateKeyException(customMessage, cause);
        assertEquals(customMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithAllParameters() {
        String customMessage = "Custom message";
        Throwable cause = new RuntimeException("Cause");
        DuplicateKeyException exception = new DuplicateKeyException(customMessage, cause, true, false);
        assertEquals(customMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertFalse(exception.getStackTrace().length > 0); // writableStackTrace is false
    }
}