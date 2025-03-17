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
import com.example.domains.contracts.repositories.LanguageRepository;
import com.example.domains.entities.Language;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;





class LanguageServiceImplTest {

    @Mock
    private LanguageRepository dao;

    @InjectMocks
    private LanguageServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<Language> languages = Arrays.asList(new Language(1, "English"), new Language(2, "Spanish"));
        when(dao.findAll()).thenReturn(languages);

        List<Language> result = service.getAll();

        assertEquals(2, result.size());
        verify(dao).findAll();
    }

    @Test
    void testGetOne() {
        Language language = new Language(1, "English");
        when(dao.findById(1)).thenReturn(Optional.of(language));

        Optional<Language> result = service.getOne(1);

        assertTrue(result.isPresent());
        assertEquals("English", result.get().getName());
        verify(dao).findById(1);
    }

    @Test
    void testAdd() throws DuplicateKeyException, InvalidDataException {
        Language language = new Language(0, "French");
        when(dao.save(language)).thenReturn(language);

        Language result = service.add(language);

        assertNotNull(result);
        assertEquals("French", result.getName());
        verify(dao).save(language);
    }

    @Test
    void testAddThrowsDuplicateKeyException() {
        Language language = new Language(1, "French");
        when(dao.existsById(1)).thenReturn(true);

        assertThrows(DuplicateKeyException.class, () -> service.add(language));
        verify(dao).existsById(1);
    }

    @Test
    void testModify() throws NotFoundException, InvalidDataException {
        Language language = new Language(1, "German");
        when(dao.existsById(1)).thenReturn(true);
        when(dao.save(language)).thenReturn(language);

        Language result = service.modify(language);

        assertNotNull(result);
        assertEquals("German", result.getName());
        verify(dao).existsById(1);
        verify(dao).save(language);
    }

    @Test
    void testModifyThrowsNotFoundException() {
        Language language = new Language(1, "German");
        when(dao.existsById(1)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> service.modify(language));
        verify(dao).existsById(1);
    }

    @Test
    void testDelete() throws InvalidDataException {
        Language language = new Language(1, "Italian");

        service.delete(language);

        verify(dao).delete(language);
    }

    @Test
    void testDeleteById() {
        service.deleteById(1);

        verify(dao).deleteById(1);
    }

    @Test
    void testNovedades() {
        Timestamp timestamp = Timestamp.valueOf("2023-01-01 00:00:00");
        List<Language> languages = Arrays.asList(new Language(1, "English"), new Language(2, "Spanish"));
        when(dao.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp)).thenReturn(languages);

        List<Language> result = service.novedades(timestamp);

        assertEquals(2, result.size());
        verify(dao).findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp);
    }
}