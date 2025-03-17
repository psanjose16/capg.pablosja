package com.example.domains.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.domains.contracts.repositories.CategoryRepository;
import com.example.domains.entities.Category;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;





class CategoryServiceImplTest {

    @Mock
    private CategoryRepository dao;

    @InjectMocks
    private CategoryServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<Category> categories = Arrays.asList(new Category(1, "Category1"), new Category(2, "Category2"));
        when(dao.findAllByOrderByName()).thenReturn(categories);

        List<Category> result = service.getAll();

        assertEquals(2, result.size());
        verify(dao).findAllByOrderByName();
    }

    @Test
    void testGetOne() {
        Category category = new Category(1, "Category1");
        when(dao.findById(1)).thenReturn(Optional.of(category));

        Optional<Category> result = service.getOne(1);

        assertTrue(result.isPresent());
        assertEquals("Category1", result.get().getName());
        verify(dao).findById(1);
    }

    @Test
    void testAdd() throws DuplicateKeyException, InvalidDataException {
        Category category = new Category(0, "Category1");
        when(dao.save(category)).thenReturn(category);

        Category result = service.add(category);

        assertNotNull(result);
        assertEquals("Category1", result.getName());
        verify(dao).save(category);
    }

    @Test
    void testAddThrowsDuplicateKeyException() {
        Category category = new Category(1, "Category1");
        when(dao.existsById(1)).thenReturn(true);

        assertThrows(DuplicateKeyException.class, () -> service.add(category));
        verify(dao).existsById(1);
    }

    @Test
    void testModify() throws NotFoundException, InvalidDataException {
        Category category = new Category(1, "Category1");
        when(dao.existsById(1)).thenReturn(true);
        when(dao.save(category)).thenReturn(category);

        Category result = service.modify(category);

        assertNotNull(result);
        assertEquals("Category1", result.getName());
        verify(dao).existsById(1);
        verify(dao).save(category);
    }

    @Test
    void testModifyThrowsNotFoundException() {
        Category category = new Category(1, "Category1");
        when(dao.existsById(1)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> service.modify(category));
        verify(dao).existsById(1);
    }

    @Test
    void testDelete() throws InvalidDataException {
        Category category = new Category(1, "Category1");

        service.delete(category);

        verify(dao).delete(category);
    }

    @Test
    void testDeleteById() {
        service.deleteById(1);

        verify(dao).deleteById(1);
    }

    @Test
    void testNovedades() {
        Timestamp timestamp = Timestamp.valueOf("2023-01-01 00:00:00");
        List<Category> categories = Arrays.asList(new Category(1, "Category1"), new Category(2, "Category2"));
        when(dao.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp)).thenReturn(categories);

        List<Category> result = service.novedades(timestamp);

        assertEquals(2, result.size());
        verify(dao).findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp);
    }
}