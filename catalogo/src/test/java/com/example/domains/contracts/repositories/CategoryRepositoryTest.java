package com.example.domains.contracts.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.domains.entities.Category;





@SpringBootTest
class CategoryRepositoryTest {

    @Mock
    private CategoryRepository categoryRepository;

    public CategoryRepositoryTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllByOrderByName() {
        List<Category> mockCategories = Arrays.asList(
            new Category(1, "Action", new Timestamp(System.currentTimeMillis())),
            new Category(2, "Comedy", new Timestamp(System.currentTimeMillis()))
        );

        when(categoryRepository.findAllByOrderByName()).thenReturn(mockCategories);

        List<Category> categories = categoryRepository.findAllByOrderByName();

        assertThat(categories).isNotNull();
        assertThat(categories).hasSize(2);
        assertThat(categories.get(0).getName()).isEqualTo("Action");
        assertThat(categories.get(1).getName()).isEqualTo("Comedy");
    }

    @Test
    void testFindByLastUpdateGreaterThanEqualOrderByLastUpdate() {
        Timestamp timestamp = Timestamp.valueOf("2023-01-01 00:00:00");
        List<Category> mockCategories = Arrays.asList(
            new Category(1, "Action", Timestamp.valueOf("2023-01-02 00:00:00")),
            new Category(2, "Comedy", Timestamp.valueOf("2023-01-03 00:00:00"))
        );

        when(categoryRepository.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp)).thenReturn(mockCategories);

        List<Category> categories = categoryRepository.findByLastUpdateGreaterThanEqualOrderByLastUpdate(timestamp);

        assertThat(categories).isNotNull();
        assertThat(categories).hasSize(2);
        assertThat(categories.get(0).getLastUpdate()).isAfterOrEqualTo(timestamp);
        assertThat(categories.get(1).getLastUpdate()).isAfterOrEqualTo(timestamp);
    }
}