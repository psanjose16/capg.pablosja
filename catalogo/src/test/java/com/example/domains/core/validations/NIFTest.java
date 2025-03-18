package com.example.domains.core.validations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;





class NIFTest {

    @Test
    void testValidNIF() {
        NIF.Validator validator = new NIF.Validator();
        assertTrue(validator.isValid("12345678Z", null)); // Replace with a valid NIF format
    }

    @Test
    void testInvalidNIF() {
        NIF.Validator validator = new NIF.Validator();
        assertFalse(validator.isValid("12345678A", null)); // Replace with an invalid NIF format
    }

    @Test
    void testNullNIF() {
        NIF.Validator validator = new NIF.Validator();
        assertTrue(validator.isValid(null, null)); // Null values should be valid
    }
}