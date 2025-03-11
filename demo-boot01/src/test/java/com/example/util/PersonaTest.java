package com.example.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



public class PersonaTest {

    @Test
    public void testPersonaConstructor() {
        Persona persona = new Persona(1, "Juan");
        assertEquals(1, persona.id);
        assertEquals("Juan", persona.nombre);
        assertEquals("Pepe", persona.apellidos); // Default value
    }

    @Test
    public void testDefaultValues() {
        Persona persona = new Persona(2, "Maria");
        assertEquals(2, persona.id);
        assertEquals("Maria", persona.nombre);
        assertEquals("Pepe", persona.apellidos); // Default value
    }
}
