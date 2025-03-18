
package com.example.domains.core.contracts.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;






class DomainServiceTest {

    @Mock
    private DomainService<Object, Integer> domainService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<Object> mockList = List.of(new Object(), new Object());
        when(domainService.getAll()).thenReturn(mockList);

        List<Object> result = domainService.getAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(domainService).getAll();
    }

    @Test
    void testGetOne() {
        Object mockObject = new Object();
        when(domainService.getOne(1)).thenReturn(Optional.of(mockObject));

        Optional<Object> result = domainService.getOne(1);

        assertTrue(result.isPresent());
        assertEquals(mockObject, result.get());
        verify(domainService).getOne(1);
    }

    @Test
    void testAdd() throws DuplicateKeyException, InvalidDataException {
        Object mockObject = new Object();
        when(domainService.add(mockObject)).thenReturn(mockObject);

        Object result = domainService.add(mockObject);

        assertNotNull(result);
        assertEquals(mockObject, result);
        verify(domainService).add(mockObject);
    }

    @Test
    void testModify() throws NotFoundException, InvalidDataException {
        Object mockObject = new Object();
        when(domainService.modify(mockObject)).thenReturn(mockObject);

        Object result = domainService.modify(mockObject);

        assertNotNull(result);
        assertEquals(mockObject, result);
        verify(domainService).modify(mockObject);
    }

    @Test
    void testDelete() throws InvalidDataException {
        Object mockObject = new Object();

        domainService.delete(mockObject);

        verify(domainService).delete(mockObject);
    }

    @Test
    void testDeleteById() {
        domainService.deleteById(1);

        verify(domainService).deleteById(1);
    }
}