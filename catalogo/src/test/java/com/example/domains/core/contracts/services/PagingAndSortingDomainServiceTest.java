package com.example.domains.core.contracts.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;





class PagingAndSortingDomainServiceTest {

    @SuppressWarnings("unchecked")
    private static <T> Iterable<T> mockIterable() {
        return mock(Iterable.class);
    }

    @Test
    void testGetAllWithSort() {
        Iterable<Object> expected = mockIterable();
        @SuppressWarnings("unchecked")
        PagingAndSortingDomainService<Object, Object> service = mock(PagingAndSortingDomainService.class);
        Sort sort = Sort.by("name");

        when(service.getAll(sort)).thenReturn(expected);

        // Act
        Iterable<Object> result = service.getAll(sort);

        // Assert
        assertEquals(expected, result);
        verify(service).getAll(sort);
    }

    @Test
    void testGetAllWithPageable() {
        // Arrange
        PagingAndSortingDomainService<Object, Object> service = mock(PagingAndSortingDomainService.class);
        Pageable pageable = mock(Pageable.class);

        Page<Object> expected = mock(Page.class);
        when(service.getAll(pageable)).thenReturn(expected);

        // Act
        Page<Object> result = service.getAll(pageable);

        // Assert
        assertEquals(expected, result);
        verify(service).getAll(pageable);
    }
}