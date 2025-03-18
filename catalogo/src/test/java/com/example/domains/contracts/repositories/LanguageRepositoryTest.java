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
import org.springframework.boot.test.context.SpringBootTest;
import com.example.domains.entities.Language;





@SpringBootTest
class LanguageRepositoryTest {

    @Mock
    private LanguageRepository languageRepository;

    public LanguageRepositoryTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllByOrderByName() {
        List<Language> mockLanguages = Arrays.asList(
            new Language(1, "English", new Timestamp(System.currentTimeMillis())),
            new Language(2, "Spanish", new Timestamp(System.currentTimeMillis()))
        );

        when(languageRepository.findAllByOrderByName()).thenReturn(mockLanguages);

        List<Language> result = languageRepository.findAllByOrderByName();
        assertEquals(2, result.size());
        assertEquals("English", result.get(0).getName());
        assertEquals("Spanish", result.get(1).getName());
    }

    @Test
    void testFindByLastUpdateGreaterThanEqualOrderByLastUpdate() {
        Timestamp timestamp = Timestamp.valueOf("2023-01-01 00:00:00");
        List<Language> mockLanguages = Arrays.asList(
            new Language(1, "English", Timestamp.valueOf("2023-01-02 00:00:00")),
            new Language(2, "Spanish", Timestamp.valueOf("2023-01-03 00:00:00"))
        );

        when(languageRepository.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp)).thenReturn(mockLanguages);

        List<Language> result = languageRepository.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp);
        assertEquals(2, result.size());
        assertEquals("English", result.get(0).getName());
        assertEquals("Spanish", result.get(1).getName());
    }
}