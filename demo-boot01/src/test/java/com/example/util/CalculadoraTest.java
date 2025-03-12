package com.example.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

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

    @Nested
	@DisplayName("Suplanta")
	class Suplantaciones {
		@Test
		void suplanta() {
			var calc = mock(Calculadora.class);
			when(calc.suma(anyInt(), anyInt())).thenReturn(3).thenReturn(5);

			var actual = calc.suma(2, 2);
			assertEquals(3, actual);
			assertEquals(5, calc.suma(2, 2));
			assertEquals(5, calc.suma(7,3));
		}
		@Test
		void suplanta2() {
			var calc = mock(Calculadora.class);
			when(calc.suma(anyInt(), anyInt())).thenReturn(4);
			var obj = new Factura(calc, null);
			var actual = obj.calcularTotal(2, 2);
			assertEquals(4, actual);
			verify(calc).suma(2, 2);
		}
		@Test
		void Integracion() {
			var obj = new Factura(new Calculadora(), null);
			var actual = obj.calcularTotal(2, 2);
			assertEquals(4, actual);
		}
}}
