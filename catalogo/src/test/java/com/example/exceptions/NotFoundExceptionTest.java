
package com.example.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;





class NotFoundExceptionTest {

    @Test
    void testDefaultConstructor() {
        NotFoundException exception = new NotFoundException();
        assertEquals("Not found", exception.getMessage());
    }

    @Test
    void testConstructorWithMessage() {
        String customMessage = "Custom not found message";
        NotFoundException exception = new NotFoundException(customMessage);
        assertEquals(customMessage, exception.getMessage());
    }

    @Test
    void testConstructorWithCause() {
        Throwable cause = new RuntimeException("Cause of the exception");
        NotFoundException exception = new NotFoundException(cause);
        assertEquals("Not found", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        String customMessage = "Custom not found message";
        Throwable cause = new RuntimeException("Cause of the exception");
        NotFoundException exception = new NotFoundException(customMessage, cause);
        assertEquals(customMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithAllParameters() {
        String customMessage = "Custom not found message";
        Throwable cause = new RuntimeException("Cause of the exception");
        NotFoundException exception = new NotFoundException(customMessage, cause, true, false);
        assertEquals(customMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}