package com.example.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CalculadoraTest {

    @Test
    public void testSumaInt() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.suma(2, 3));
        assertEquals(-1, calc.suma(2, -3));
        assertEquals(0, calc.suma(0, 0));
    }

    @Test
    public void testSumaDouble() {
        Calculadora calc = new Calculadora();
        assertEquals(5.0, calc.suma(2.0, 3.0), 0.000000000000001);
        assertEquals(-1.0, calc.suma(2.0, -3.0), 0.000000000000001);
        assertEquals(0.0, calc.suma(0.0, 0.0), 0.000000000000001);
    }

    @Test
    public void testDivideInt() {
        Calculadora calc = new Calculadora();
        assertEquals(2, calc.divide(6, 3));
        assertEquals(-2, calc.divide(6, -3));
        assertEquals(0, calc.divide(0, 3));
    }

    @Test
    public void testDivideDouble() {
        Calculadora calc = new Calculadora();
        assertEquals(2.0, calc.divide(6.0, 3.0), 0.000000000000001);
        assertEquals(-2.0, calc.divide(6.0, -3.0), 0.000000000000001);
        assertEquals(0.0, calc.divide(0.0, 3.0), 0.000000000000001);
    }

    @Test
    public void testDivideByZero() {
        Calculadora calc = new Calculadora();
        assertThrows(ArithmeticException.class, () -> calc.divide(1, 0));
        assertThrows(ArithmeticException.class, () -> calc.divide(1.0, 0.0));
    }
}
