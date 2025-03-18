package com.example.domains.core.validations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





class GreaterThanValidatorTest {

    private GreaterThanValidator validator;

    @BeforeEach
    void setUp() {
        validator = new GreaterThanValidator();
        validator.initialize(new GreaterThan() {
            @Override
            public Class<? extends java.lang.annotation.Annotation> annotationType() {
                return GreaterThan.class;
            }

            @Override
            public String minor() {
                return "startDate";
            }

            @Override
            public String major() {
                return "endDate";
            }

            @Override
            public String message() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'message'");
            }

            @Override
            public Class<?>[] groups() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'groups'");
            }

            @Override
            public Class<? extends Payload>[] payload() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'payload'");
            }
        });
    }

    @Test
    void testIsValid_withValidDates() {
        TestObject testObject = new TestObject(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31));
        assertTrue(validator.isValid(testObject, null));
    }

    @Test
    void testIsValid_withInvalidDates() {
        TestObject testObject = new TestObject(LocalDate.of(2023, 12, 31), LocalDate.of(2023, 1, 1));
        assertFalse(validator.isValid(testObject, null));
    }

    @Test
    void testIsValid_withNullValues() {
        TestObject testObject = new TestObject(null, LocalDate.of(2023, 12, 31));
        assertFalse(validator.isValid(testObject, null));
    }

    @Test
    void testIsValid_withEqualValues() {
        TestObject testObject = new TestObject(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1));
        assertFalse(validator.isValid(testObject, null));
    }

    static class TestObject {
        private LocalDate startDate;
        private LocalDate endDate;

        public TestObject(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }
    }
}