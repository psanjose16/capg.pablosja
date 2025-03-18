package com.example.domains.core.contracts.repositories;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;






class RepositoryWithProjectionsTest {

    @Mock
    private RepositoryWithProjections repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllByWithClass() {
        List<String> mockResult = List.of("item1", "item2");
        when(repository.findAllBy(String.class)).thenReturn(mockResult);

        List<String> result = repository.findAllBy(String.class);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("item1", result.get(0));
        verify(repository, times(1)).findAllBy(String.class);
    }

    @Test
    void testFindAllByWithSortAndClass() {
        Sort sort = Sort.by("field");
        List<String> mockResult = List.of("item1", "item2");
        when(repository.findAllBy(sort, String.class)).thenReturn(mockResult);

        Iterable<String> result = repository.findAllBy(sort, String.class);

        assertNotNull(result);
        assertEquals(mockResult, result);
        verify(repository, times(1)).findAllBy(sort, String.class);
    }

    @Test
    void testFindAllByWithPageableAndClass() {
        Pageable pageable = Pageable.unpaged();
        Page<String> mockPage = new PageImpl<>(List.of("item1", "item2"));
        when(repository.findAllBy(pageable, String.class)).thenReturn(mockPage);

        Page<String> result = repository.findAllBy(pageable, String.class);

        assertNotNull(result);
        assertEquals(2, result.getTotalElements());
        assertEquals("item1", result.getContent().get(0));
        verify(repository, times(1)).findAllBy(pageable, String.class);
    }
}