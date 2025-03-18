package com.example.domains.contracts.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.domains.entities.Category;





class CategoryServiceTest {

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testNovedades() {
        // Arrange
        Timestamp fecha = new Timestamp(System.currentTimeMillis());
        List<Category> expectedCategories = Arrays.asList(new Category(), new Category());
        when(categoryService.novedades(fecha)).thenReturn(expectedCategories);

        // Act
        List<Category> result = categoryService.novedades(fecha);

        // Assert
        assertNotNull(result);
        verify(categoryService).novedades(fecha);
    }
}