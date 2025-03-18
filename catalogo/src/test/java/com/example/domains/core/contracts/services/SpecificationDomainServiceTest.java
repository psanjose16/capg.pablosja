package com.example.domains.core.contracts.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;






class SpecificationDomainServiceTest<E, K> {

    @Mock
    private SpecificationDomainService<E, K> service;

    @Mock
    private Specification<E> specification;

    @Mock
    private Pageable pageable;

    @Mock
    private Sort sort;

    @Mock
    private Page<E> page;

    @Mock
    private List<E> list;

    @Mock
    private E entity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetOne() {
        when(service.getOne(specification)).thenReturn(Optional.of(entity));

        Optional<E> result = service.getOne(specification);

        assertTrue(result.isPresent());
        assertEquals(entity, result.get());
        verify(service).getOne(specification);
    }

    @Test
    void testGetAllWithSpecification() {
        when(service.getAll(specification)).thenReturn(list);

        List<E> result = service.getAll(specification);

        assertNotNull(result);
        assertEquals(list, result);
        verify(service).getAll(specification);
    }

    @Test
    void testGetAllWithSpecificationAndPageable() {
        when(service.getAll(specification, pageable)).thenReturn(page);

        Page<E> result = service.getAll(specification, pageable);

        assertNotNull(result);
        assertEquals(page, result);
        verify(service).getAll(specification, pageable);
    }

    @Test
    void testGetAllWithSpecificationAndSort() {
        when(service.getAll(specification, sort)).thenReturn(list);

        List<E> result = service.getAll(specification, sort);

        assertNotNull(result);
        assertEquals(list, result);
        verify(service).getAll(specification, sort);
    }
}