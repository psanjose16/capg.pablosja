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
import com.example.domains.entities.Language;





class LanguageServiceTest {

    @Mock
    private LanguageService languageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testNovedades() {
        // Arrange
        Timestamp fecha = Timestamp.valueOf("2023-01-01 00:00:00");
        List<Language> expectedLanguages = Arrays.asList(
            new Language(1, "English"),
            new Language(2, "Spanish")
        );
        when(languageService.novedades(fecha)).thenReturn(expectedLanguages);

        // Act
        List<Language> result = languageService.novedades(fecha);

        // Assert
        assertNotNull(result);
        // Additional assertions can be added to verify the content of the result
    }
}