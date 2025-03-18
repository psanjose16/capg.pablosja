package com.example.demobatch.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;





public class PersonaTest {

    @Test
    public void testPersonaConstructorAndGetters() {
        // Arrange
        long id = 1L;
        String nombre = "John Doe";
        String correo = "john.doe@example.com";
        String ip = "192.168.1.1";

        // Act
        Persona persona = new Persona(id, nombre, correo, ip);

        // Assert
        assertEquals(id, persona.getId());
        assertEquals(nombre, persona.getNombre());
        assertEquals(correo, persona.getCorreo());
        assertEquals(ip, persona.getIp());
    }

    @Test
    public void testSetters() {
        // Arrange
        Persona persona = new Persona(0, null, null, null);

        // Act
        persona.setId(2L);
        persona.setNombre("Jane Doe");
        persona.setCorreo("jane.doe@example.com");
        persona.setIp("192.168.1.2");

        // Assert
        assertEquals(2L, persona.getId());
        assertEquals("Jane Doe", persona.getNombre());
        assertEquals("jane.doe@example.com", persona.getCorreo());
        assertEquals("192.168.1.2", persona.getIp());
    }

    @Test
    public void testToString() {
        // Arrange
        Persona persona = new Persona(3L, "Alice", "alice@example.com", "192.168.1.3");

        // Act
        String toStringResult = persona.toString();

        // Assert
        assertNotNull(toStringResult);
        assertEquals(true, toStringResult.contains("Alice"));
        assertEquals(true, toStringResult.contains("alice@example.com"));
        assertEquals(true, toStringResult.contains("192.168.1.3"));
    }
}