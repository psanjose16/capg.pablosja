package com.example.domains.contracts.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.domains.entities.Film;





class FilmServiceTest {

    @Mock
    private FilmService filmService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testNovedades() {
        // Arrange
        Timestamp fecha = Timestamp.valueOf("2023-01-01 00:00:00");
        List<Film> mockFilms = Arrays.asList(new Film(), new Film());
        when(filmService.novedades(fecha)).thenReturn(mockFilms);

        // Act
        List<Film> result = filmService.novedades(fecha);

        // Assert
        assertNotNull(result);
    }
}