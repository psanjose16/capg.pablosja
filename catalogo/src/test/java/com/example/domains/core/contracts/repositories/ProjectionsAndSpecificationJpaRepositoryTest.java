package com.example.domains.core.contracts.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;




class ProjectionsAndSpecificationJpaRepositoryTest {

    @Mock
    private ProjectionsAndSpecificationJpaRepository<Object, Long> repository;

    @Test
    void testFindAllByClass() {
        // Arrange
        Class<String> type = String.class;
        List<String> mockResult = List.of("Test1", "Test2");
        when(repository.findAllBy(type)).thenReturn(mockResult);

        // Act
        List<String> result = repository.findAllBy(type);

        // Assert
        assertThat(result).isNotNull().hasSize(2).contains("Test1", "Test2");
        verify(repository).findAllBy(type);
    }

    @Test
    void testFindAllBySortAndClass() {
        // Arrange
        Sort sort = Sort.by("name");
        Class<String> type = String.class;
        List<String> mockResult = List.of("Test1", "Test2");
        when(repository.findAllBy(sort, type)).thenReturn(mockResult);

        // Act
        List<String> result = repository.findAllBy(sort, type);

        // Assert
        assertThat(result).isNotNull().hasSize(2).contains("Test1", "Test2");
        verify(repository).findAllBy(sort, type);
    }

    @Test
    void testFindAllByPageableAndClass() {
        // Arrange
        PageRequest pageable = PageRequest.of(0, 2);
        Class<String> type = String.class;
        Page<String> mockPage = new PageImpl<>(List.of("Test1", "Test2"));
        when(repository.findAllBy(pageable, type)).thenReturn(mockPage);

        // Act
        Page<String> result = repository.findAllBy(pageable, type);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getContent()).hasSize(2).contains("Test1", "Test2");
        verify(repository).findAllBy(pageable, type);
    }
}