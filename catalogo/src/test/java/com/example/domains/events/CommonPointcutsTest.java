package com.example.domains.events;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Test;





class CommonPointcutsTest {

    @Test
    void testPointcutsExist() throws NoSuchMethodException {
        // Ensure all pointcuts are defined
        assertNotNull(CommonPointcuts.class.getDeclaredMethod("cualquierMetodoPublico"));
        assertNotNull(CommonPointcuts.class.getDeclaredMethod("repositorios"));
        assertNotNull(CommonPointcuts.class.getDeclaredMethod("servicios"));
        assertNotNull(CommonPointcuts.class.getDeclaredMethod("metodosAdd"));
        assertNotNull(CommonPointcuts.class.getDeclaredMethod("metodosModify"));
        assertNotNull(CommonPointcuts.class.getDeclaredMethod("metodosDelete"));
        assertNotNull(CommonPointcuts.class.getDeclaredMethod("metodosDeleteById"));
        assertNotNull(CommonPointcuts.class.getDeclaredMethod("requiredAuthentication"));
    }
}