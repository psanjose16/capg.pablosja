package com.example.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;





class BadRequestExceptionTest {

    @Test
    void testBadRequestExceptionWithMessage() {
        String message = "This is a bad request";
        BadRequestException exception = new BadRequestException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testBadRequestExceptionWithMessageAndCause() {
        String message = "This is a bad request";
        Throwable cause = new RuntimeException("Cause of the exception");
        BadRequestException exception = new BadRequestException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testBadRequestExceptionWithAllParameters() {
        String message = "This is a bad request";
        Throwable cause = new RuntimeException("Cause of the exception");
        boolean enableSuppression = true;
        boolean writableStackTrace = false;

        BadRequestException exception = new BadRequestException(message, cause, enableSuppression, writableStackTrace);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testBadRequestExceptionThrows() {
        assertThrows(BadRequestException.class, () -> {
            throw new BadRequestException("This is a bad request");
        });
    }
}