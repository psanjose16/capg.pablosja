package com.example.domains.contracts.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.domains.entities.Film;





class FilmRepositoryTest {

    @Mock
    private FilmRepository filmRepository;

    public FilmRepositoryTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByLastUpdateGreaterThanEqualOrderByLastUpdate() {
        // Arrange
        Timestamp timestamp = Timestamp.valueOf("2023-01-01 00:00:00");
        Film film1 = new Film();
        film1.setLastUpdate(Timestamp.valueOf("2023-01-02 00:00:00"));
        Film film2 = new Film();
        film2.setLastUpdate(Timestamp.valueOf("2023-01-03 00:00:00"));
        List<Film> expectedFilms = Arrays.asList(film1, film2);

        when(filmRepository.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp)).thenReturn(expectedFilms);

        // Act
        List<Film> actualFilms = filmRepository.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp);

        // Assert
        assertEquals(expectedFilms, actualFilms);
    }
}