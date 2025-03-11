package com.example.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.test.utils.Smoke;

class CalculadoraTest {
    static Calculadora calc;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        calc = new Calculadora();
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Nested
    @DisplayName("Método: suma")
    class Suma {
        @Nested
        @DisplayName("Casos válidos")
        class OK {
            @Test
            @DisplayName("Suma dos enteros")
            @Smoke
            void testSuma() {
                var actual = calc.suma(2, 3);
                assertEquals(5, actual);
            }

            @Test
            @DisplayName("Suma dos reales")
            void testSuma2() {
                var actual = calc.suma(0.1, 0.2);
                assertEquals(0.3, actual);
            }

            @Test
            @DisplayName("Suma dos reales: resta")
            void testSuma3() {
                assertEquals(0.1, calc.suma(1, -0.9));
            }

            @DisplayName("Suma dos números")
            @ParameterizedTest(name = "{0} + {1} = {2}")
            @CsvSource({ "1,2,3", "2,-1,1", "-1,2,1", "-2,-1,-3", "0,0,0", "0.1,0.2,0.3" })
            void testSumaParametrizada(double operando1, double operando2, double esperado) {
                var actual = calc.suma(operando1, operando2);
                assertEquals(esperado, actual);
            }
        }

        @Nested
        @DisplayName("Casos inválidos")
        class KO {
            @Test
            @DisplayName("Suma dos enteros grandes")
            @Disabled
            void testSumaInt() {
                var actual = calc.suma(Integer.MAX_VALUE, 1);
                assertEquals(5, actual);
                assertTrue(1.0 / 0 > 0);
                assertEquals(5, 1.0 / 0);
            }
        }
    }

    @Nested
    @DisplayName("Método: divide")
    class Divide {
        @Nested
        @DisplayName("Casos válidos")
        class OK {
            @Test
            @DisplayName("Divide dos enteros")
            void testDivide() {
                assertEquals(0.5, calc.divide(1.0, 2));
            }

            @Test
            @DisplayName("Divide dos enteros sin decimales")
            void testDivideInt() {
                assertEquals(2, calc.divide(4, 2));
            }

            @Test
            @DisplayName("Divide dos reales")
            void testDivideDouble() {
                assertEquals(0.5, calc.divide(1.0, 2.0));
            }

            @Test
            @DisplayName("Divide por uno")
            void testDivideByOne() {
                assertEquals(5, calc.divide(5, 1));
            }
        }

        @Nested
        @DisplayName("Casos inválidos")
        class KO {
            @Test
            @DisplayName("Divide por cero")
            void testDivide2() {
                var ex = assertThrows(ArithmeticException.class, () -> calc.divide(1, 0));
                assertEquals("/ by zero", ex.getMessage());
            }

            @Test
            @DisplayName("Divide por cero: try")
            void testDivide3() {
                try {
                    calc.divide(1, 0);
                    fail("No se ha lanzado excepción");
                } catch (ArithmeticException ex) {
                    assertEquals("/ by zero", ex.getMessage());
                }
            }
        }
    }

    @Nested
    @DisplayName("Método: roundIEEE754")
    class RoundIEEE754 {
        @Test
        @DisplayName("Redondea un número positivo")
        void testRoundPositive() {
            var actual = calc.roundIEEE754(0.12345678901234567);
            assertEquals(0.1234567890123457, actual);
        }

        @Test
        @DisplayName("Redondea un número negativo")
        void testRoundNegative() {
            var actual = calc.roundIEEE754(-0.12345678901234567);
            assertEquals(-0.1234567890123457, actual);
        }

        @Test
        @DisplayName("Redondea cero")
        void testRoundZero() {
            var actual = calc.roundIEEE754(0.0);
            assertEquals(0.0, actual);
        }
    }
}