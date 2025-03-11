package com.example.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.util.Persona;

public class PersonaTest {
	@Test
	void createPersona() {
		var p = new Persona(1, "Pepe");
		
		assertNotNull(p);
		assertAll("Contructor", 
				() -> assertEquals(1, p.id),
				() -> assertEquals("Pepe", p.nombre, "nombre"),
				() -> assertEquals("Pepe", p.apellidos, "apellidos")
				);
		assertEquals(1, p.id);
		assertEquals("Pepe", p.nombre);
	}
}