package com.example.domains.core.validations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




class CadenasValidatorTest {

    @Test
    void testIsNIF_ValidNIF() {
        assertTrue(CadenasValidator.isNIF("12345678Z"));
    }

    @Test
    void testIsNIF_InvalidNIF() {
        assertFalse(CadenasValidator.isNIF("12345678A"));
    }

    @Test
    void testIsNIF_NullValue() {
        assertFalse(CadenasValidator.isNIF(null));
    }

    @Test
    void testIsNIF_EmptyString() {
        assertFalse(CadenasValidator.isNIF(""));
    }

    @Test
    void testIsNIF_InvalidFormat() {
        assertFalse(CadenasValidator.isNIF("ABCDEFGH"));
    }

    @Test
    void testIsNotNIF_ValidNIF() {
        assertFalse(CadenasValidator.isNotNIF("12345678Z"));
    }

    @Test
    void testIsNotNIF_InvalidNIF() {
        assertTrue(CadenasValidator.isNotNIF("12345678A"));
    }

    @Test
    void testIsNotNIF_NullValue() {
        assertTrue(CadenasValidator.isNotNIF(null));
    }

    @Test
    void testIsNotNIF_EmptyString() {
        assertTrue(CadenasValidator.isNotNIF(""));
    }
}