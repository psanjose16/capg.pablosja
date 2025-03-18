package com.example.domains.core.validations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





class GreaterThanTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @GreaterThan(minor = "value1", major = "value2", message = "value1 must be less than value2")
    static class TestObject {
        private final Integer value1;
        private final Integer value2;

        public TestObject(Integer value1, Integer value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        public Integer getValue1() {
            return value1;
        }

        public Integer getValue2() {
            return value2;
        }
    }

    @Test
    void testValidValues() {
        TestObject obj = new TestObject(5, 10);
        var violations = validator.validate(obj);
        assertTrue(violations.isEmpty(), "Expected no validation errors");
    }

    @Test
    void testInvalidValues() {
        TestObject obj = new TestObject(10, 5);
        var violations = validator.validate(obj);
        assertFalse(violations.isEmpty(), "Expected validation errors");
    }

    @Test
    void testEqualValues() {
        TestObject obj = new TestObject(10, 10);
        var violations = validator.validate(obj);
        assertFalse(violations.isEmpty(), "Expected validation errors");
    }

    @Test
    void testNullValues() {
        TestObject obj = new TestObject(null, 10);
        var violations = validator.validate(obj);
        assertFalse(violations.isEmpty(), "Expected validation errors");

        obj = new TestObject(10, null);
        violations = validator.validate(obj);
        assertFalse(violations.isEmpty(), "Expected validation errors");
    }
}