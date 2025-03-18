package com.example.domains.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import com.example.domains.contracts.repositories.FilmRepository;
import com.example.domains.entities.Film;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;





class FilmServiceImplTest {

    @Mock
    private FilmRepository dao;

    @InjectMocks
    private FilmServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<Film> films = List.of(new Film(), new Film());
        when(dao.findAll()).thenReturn(films);

        List<Film> result = service.getAll();

        assertEquals(films.size(), result.size());
        verify(dao).findAll();
    }

    @Test
    void testGetOne() {
        Film film = new Film();
        when(dao.findById(1)).thenReturn(Optional.of(film));

        Optional<Film> result = service.getOne(1);

        assertTrue(result.isPresent());
        assertEquals(film, result.get());
        verify(dao).findById(1);
    }

    @Test
    void testAdd() throws DuplicateKeyException, InvalidDataException {
        Film film = new Film();
        when(dao.existsById(film.getFilmId())).thenReturn(false);
        when(dao.save(film)).thenReturn(film);

        Film result = service.add(film);

        assertEquals(film, result);
        verify(dao).existsById(film.getFilmId());
        verify(dao).save(film);
    }

    @Test
    void testModify() throws NotFoundException, InvalidDataException {
        Film film = new Film();
        Film existingFilm = new Film();
        when(dao.findById(film.getFilmId())).thenReturn(Optional.of(existingFilm));
        when(dao.save(any(Film.class))).thenReturn(film);

        Film result = service.modify(film);

        assertEquals(film, result);
        verify(dao).findById(film.getFilmId());
        verify(dao).save(any(Film.class));
    }

    @Test
    void testDeleteById() {
        doNothing().when(dao).deleteById(1);

        service.deleteById(1);

        verify(dao).deleteById(1);
    }

    @Test
    void testNovedades() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<Film> films = List.of(new Film(), new Film());
        when(dao.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp)).thenReturn(films);

        List<Film> result = service.novedades(timestamp);

        assertEquals(films.size(), result.size());
        verify(dao).findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp);
    }
}