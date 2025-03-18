package com.example.demobatch.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;





class PersonaDTOTest {

    @Test
    void testPersonaDTOConstructorAndGetters() {
        PersonaDTO persona = new PersonaDTO(1L, "John", "Doe", "john.doe@example.com", "Male", "192.168.1.1");

        assertEquals(1L, persona.getId());
        assertEquals("John", persona.getNombre());
        assertEquals("Doe", persona.getApellidos());
        assertEquals("john.doe@example.com", persona.getCorreo());
        assertEquals("Male", persona.getSexo());
        assertEquals("192.168.1.1", persona.getIp());
    }

    @Test
    void testSetters() {
        PersonaDTO persona = new PersonaDTO(0L, null, null, null, null, null);

        persona.setId(2L);
        persona.setNombre("Jane");
        persona.setApellidos("Smith");
        persona.setCorreo("jane.smith@example.com");
        persona.setSexo("Female");
        persona.setIp("10.0.0.1");

        assertEquals(2L, persona.getId());
        assertEquals("Jane", persona.getNombre());
        assertEquals("Smith", persona.getApellidos());
        assertEquals("jane.smith@example.com", persona.getCorreo());
        assertEquals("Female", persona.getSexo());
        assertEquals("10.0.0.1", persona.getIp());
    }

    @Test
    void testToString() {
        PersonaDTO persona = new PersonaDTO(3L, "Alice", "Johnson", "alice.johnson@example.com", "Female", "127.0.0.1");

        String toStringResult = persona.toString();
        assertNotNull(toStringResult);
        assertEquals(true, toStringResult.contains("Alice"));
        assertEquals(true, toStringResult.contains("Johnson"));
        assertEquals(true, toStringResult.contains("alice.johnson@example.com"));
    }
}