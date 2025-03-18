package com.example.domains.core.contracts.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;





class ProjectionDomainServiceTest {

    @Mock
    private ProjectionDomainService<Object, Long> projectionDomainService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetByProjectionWithClass() {
        Class<String> type = String.class;
        List<String> mockResult = List.of("Projection1", "Projection2");
        when(projectionDomainService.getByProjection(type)).thenReturn(mockResult);

        List<String> result = projectionDomainService.getByProjection(type);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Projection1", result.get(0));
        verify(projectionDomainService).getByProjection(type);
    }

    @Test
    void testGetByProjectionWithSortAndClass() {
        Sort sort = Sort.by("field");
        Class<String> type = String.class;
        Iterable<String> mockResult = List.of("Projection1", "Projection2");
        when(projectionDomainService.getByProjection(sort, type)).thenReturn(mockResult);

        Iterable<String> result = projectionDomainService.getByProjection(sort, type);

        assertNotNull(result);
        assertTrue(result.iterator().hasNext());
        verify(projectionDomainService).getByProjection(sort, type);
    }

    @Test
    void testGetByProjectionWithPageableAndClass() {
        Pageable pageable = Pageable.unpaged();
        Class<String> type = String.class;
        Page<String> mockResult = mock(Page.class);
        when(projectionDomainService.getByProjection(pageable, type)).thenReturn(mockResult);

        Page<String> result = projectionDomainService.getByProjection(pageable, type);

        assertNotNull(result);
        verify(projectionDomainService).getByProjection(pageable, type);
    }
}